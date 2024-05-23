package com.ains.groupit.calculateme.exception;

import java.io.Serial;

public class CustomRuntimeException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -9079454849611061074L;

    public CustomRuntimeException() {
        super();
    }

    public CustomRuntimeException(final String message) {
        super(message);
    }
}
