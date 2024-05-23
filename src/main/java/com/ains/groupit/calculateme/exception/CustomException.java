package com.ains.groupit.calculateme.exception;

import java.io.Serial;

public class CustomException extends Exception {

    @Serial
    private static final long serialVersionUID = -9079454849611061074L;

    public CustomException() {
        super();
    }

    public CustomException(final String message) {
        super(message);
    }
}
