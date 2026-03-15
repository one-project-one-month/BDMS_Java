package com.opom.bdms.exception;

/**
 * Thrown when a create or update would violate a unique constraint
 * (e.g., duplicate name, email, code).
 */
public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
