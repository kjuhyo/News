package com.sample.news.Service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.sample.news.DTO.NewsDto;
import com.sample.news.Entity.ReadLog;
import com.sample.news.Enum.ErrorCode;
import com.sample.news.Exception.ErrorException;
import com.sample.news.Repository.ReadLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {

    private final ReadLogRepository readLogRepository;

    /**
     * 뉴스 목록 조회
     * */
    public List<NewsDto> getNewsList(String rssUrl) throws Exception {
        try {
            // 뉴스 RSS 데이터 조회
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(new URL(rssUrl)));
            List<SyndEntry> entries = feed.getEntries();
            List<NewsDto> newsList = new ArrayList<>();

            // 읽음 로그 조회하여 key=articleID, value=true로 세팅
            Map<String, Boolean> readMap = readLogRepository.findAll().stream()
                    .collect(Collectors.toMap(
                            ReadLog::getArticleID,
                            log -> true,
                            (existing, replacement) -> existing
                    ));

            for (SyndEntry e : entries) {
                // 링크에서 articleID 추출
                String articleId = e.getLink() != null
                        ? e.getLink().substring(e.getLink().lastIndexOf("/") + 1)
                        : "";

                newsList.add(new NewsDto(
                        e.getTitle(),
                        e.getLink(),
                        e.getDescription().getValue(),
                        e.getPublishedDate().toString(),
                        e.getAuthor(),
                        readMap.getOrDefault(articleId, false)
                ));
            }
            return newsList;
        } catch (ErrorException e) {
            Map<String, Object> logData = new HashMap<>();
            logData.put("rssUrl", rssUrl);
            throw new ErrorException(ErrorCode.INTERNAL_SERVER_ERROR, logData);
        }
    }

    /**
     * 뉴스 읽음 로그 생성
     * */
    public void createNewsReadLog(String articleId) {
        try {
            ReadLog log = new ReadLog(articleId, LocalDateTime.now().toString());
            readLogRepository.save(log);
        } catch (ErrorException e) {
            Map<String, Object> logData = new HashMap<>();
            logData.put("articleId", articleId);
            throw new ErrorException(ErrorCode.INTERNAL_SERVER_ERROR, logData);
        }
    }
}

