package com.sample.news.Handler;

import com.sample.news.DTO.ErrorDto;
import com.sample.news.Enum.ErrorCode;
import com.sample.news.Exception.ErrorException;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.marker.Markers;
import org.slf4j.Marker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorDto> handleCustomException(ErrorException e)  {
        Marker marker = Markers.appendEntries(e.getLogData());
        if (e.getLogData()!=null) {
            log.error(marker, e.getErrorCode().getMessage(), e);
        } else {
            log.error(e.getErrorCode().getMessage(), e);
        }

        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.badRequest()
                .body(new ErrorDto(
                        errorCode.getCode(),
                        errorCode.getMessage()
                ));
    }
}
