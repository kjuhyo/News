package com.sample.news.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    UNKNOWN(10000, "알 수 없는 에러"),
    NEWS_NOT_FOUND(10001, "뉴스 조회 실패"),
    CATEGORIES_NOT_FOUND(10002, "카테고리 조회 실패"),
    READ_LOG_CREATE_FAILED(10003, "읽음 로그 생성 실패");

    private final Integer code;
    private final String message;
}
