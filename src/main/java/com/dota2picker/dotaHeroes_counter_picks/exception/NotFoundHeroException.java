package com.dota2picker.dotaHeroes_counter_picks.exception;

public class NotFoundHeroException extends Exception {

    public NotFoundHeroException() {
        super();
    }

    public NotFoundHeroException(String message) {
        super(message);
    }

    public NotFoundHeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundHeroException(Throwable cause) {
        super(cause);
    }

    protected NotFoundHeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
