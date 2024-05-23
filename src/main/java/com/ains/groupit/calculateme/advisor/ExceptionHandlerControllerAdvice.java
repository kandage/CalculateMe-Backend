package com.ains.groupit.calculateme.advisor;


import com.ains.groupit.calculateme.exception.CustomDuplicateException;
import com.ains.groupit.calculateme.exception.CustomException;
import com.ains.groupit.calculateme.exception.CustomRuntimeException;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

@RestControllerAdvice(basePackages = "com.ains.groupit.calculateme")
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleResourceNotFound(final CustomException exception,
                                                         final HttpServletRequest request) {
        StandardResponse<Object> response = setExceptionResponse(request, HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomRuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<StandardResponse<?>> handleException(final CustomRuntimeException exception,
                                                               final HttpServletRequest request) {
        StandardResponse<Object> response = setExceptionResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomDuplicateException.class)
    @ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<StandardResponse<?>> handleDuplicateException(final CustomDuplicateException exception,
                                                                        final HttpServletRequest request) {
        StandardResponse<Object> response = setExceptionResponse(request, HttpStatus.ALREADY_REPORTED, exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<StandardResponse<?>> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException ex,
                                                                                         final HttpServletRequest request) {
        String name = ex.getName();
        String type = Objects.requireNonNull(ex.getRequiredType()).getSimpleName();
        Object value = ex.getValue();
        String message = String.format("'%s' should be a valid '%s' and '%s' isn't",
                name, type, value);
        StandardResponse<Object> response = setExceptionResponse(request, HttpStatus.BAD_REQUEST, message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private StandardResponse<Object> setExceptionResponse(HttpServletRequest request, HttpStatus httpStatus, String message) {
        return new StandardResponse<>(httpStatus.value(), message, request.getRequestURI()
        );
    }

    @ResponseStatus(value = HttpStatus.IM_USED)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardResponse<?>> handleDuplicateEntryException(final DataIntegrityViolationException e, final HttpServletRequest request) {
        StandardResponse<Object> response = setExceptionResponse(request, HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

}

