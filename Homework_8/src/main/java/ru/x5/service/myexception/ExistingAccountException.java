package ru.x5.service.myexception;

public class ExistingAccountException extends RuntimeException {
    public ExistingAccountException() {
    }

    public ExistingAccountException(String message) {
        super(message);
    }
}
