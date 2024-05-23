package com.ains.groupit.calculateme.exception;

import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serial;

public class CustomDuplicateException extends DataIntegrityViolationException {

    @Serial
    private static final long serialVersionUID = -9079454849611061074L;

    public CustomDuplicateException(final String message) {
        super(message);
    }
}
