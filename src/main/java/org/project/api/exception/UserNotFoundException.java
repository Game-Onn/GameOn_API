package org.project.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to be thrown when a requested user is not found.
 * This exception will result in an HTTP 404 Not Found status.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    /**
     * Constructs a new UserNotFoundException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public UserNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new UserNotFoundException with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause The cause (which is saved for later retrieval by the getCause() method).
     */
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new UserNotFoundException with the specified cause and a detail message of (cause==null ? null : cause.toString())
     * (which typically contains the class and detail message of cause).
     *
     * @param cause The cause.
     */
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new UserNotFoundException with the specified detail message, cause,
     * suppression enabled or disabled, and writable stack trace enabled or disabled.
     *
     * @param message The detail message.
     * @param cause The cause.
     * @param enableSuppression Whether or not suppression is enabled or disabled.
     * @param writableStackTrace Whether or not the stack trace should be writable.
     */
    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
