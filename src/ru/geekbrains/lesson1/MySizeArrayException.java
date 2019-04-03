package ru.geekbrains.lesson1;

public class MySizeArrayException extends Exception {
    public MySizeArrayException() {
    }

    public MySizeArrayException(String message) {
        super(message);
    }

    public MySizeArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public MySizeArrayException(Throwable cause) {
        super(cause);
    }

    public MySizeArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
