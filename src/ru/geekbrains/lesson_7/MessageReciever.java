package ru.geekbrains.lesson_7;

public interface MessageReciever {
    void submitMessage(TextMessage message);
    void userConnected(String login);
    void userDisconnected(String login);
}
