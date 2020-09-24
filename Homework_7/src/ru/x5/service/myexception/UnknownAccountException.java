package ru.x5.service.myexception;

public class UnknownAccountException extends RuntimeException {
    public UnknownAccountException() {
    }

    public UnknownAccountException(String message) {
        super(message);
    }
}
