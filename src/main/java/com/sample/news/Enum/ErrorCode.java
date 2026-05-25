package com.sample.news.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    NOT_FOUND_ARTICLE(10001, "게시글이 존재하지 않습니다."),
    INTERNAL_SERVER_ERROR(10002, "서버 내부 오류입니다.");

    private final Integer code;
    private final String message;
}
