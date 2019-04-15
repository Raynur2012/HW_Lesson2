package ru.geekbrains.lesson_4;

import java.time.LocalDateTime;

public class TextMassage {
    private LocalDateTime created;
    private String userName;
    private String text;

    public TextMassage(String userName, String text) {
        this.created = LocalDateTime.now();
        this.userName = userName;
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }
}
