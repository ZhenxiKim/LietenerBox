package com.example.lietenerbox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class DataDuplicatedException extends Exception{

    public DataDuplicatedException() {
        super();
    }

    public DataDuplicatedException(String message) {
        super(message);
    }

    public DataDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected DataDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
