package org.project.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to be thrown when attempting to register a user that already exists.
 * This exception will result in an HTTP 409 Conflict status.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateUserException extends RuntimeException {

    /**
     * Constructs a new DuplicateUserException with the specified detail message.
     *
     * @param message The detail message.
     */
    public DuplicateUserException(String message) {
        super(message);
    }

    /**
     * Constructs a new DuplicateUserException with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause The cause.
     */
    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DuplicateUserException with the specified cause.
     *
     * @param cause The cause.
     */
    public DuplicateUserException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new DuplicateUserException with the specified detail message, cause,
     * suppression enabled or disabled, and writable stack trace enabled or disabled.
     *
     * @param message The detail message.
     * @param cause The cause.
     * @param enableSuppression Whether or not suppression is enabled or disabled.
     * @param writableStackTrace Whether or not the stack trace should be writable.
     */
    public DuplicateUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
