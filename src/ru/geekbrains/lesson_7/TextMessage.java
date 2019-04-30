package ru.geekbrains.lesson_7;

import java.time.LocalDateTime;

public class TextMessage {
    private LocalDateTime created;

    private String userFrom;//имя пользователя, который отправил сообщение

    private String userTo;//имя пользователя, кому мы отправляем сообщение

    private String text;

    public TextMessage(String userFrom, String userTo, String text) {
        this.created = LocalDateTime.now();
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.text = text;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
