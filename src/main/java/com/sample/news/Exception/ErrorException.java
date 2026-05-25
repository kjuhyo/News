package com.sample.news.Exception;

import com.sample.news.Enum.ErrorCode;
import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorException extends RuntimeException {

    private final ErrorCode errorCode;
    private final Map<String, Object> logData;

    public ErrorException(ErrorCode errorCode, Map<String, Object> logData) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.logData = logData;
    }
}
