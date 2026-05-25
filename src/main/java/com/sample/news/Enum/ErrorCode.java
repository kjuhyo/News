package com.sample.news.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    UNKNOWN(10000, "Unknown error"),
    NEWS_NOT_FOUND(10001, "Failed to get news"),
    CATEGORIES_NOT_FOUND(10002, "Failed to get categories"),
    READ_LOG_CREATE_FAILED(10003, "Failed to create read log");

    private final Integer code;
    private final String message;
}
