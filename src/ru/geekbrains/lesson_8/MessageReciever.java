package ru.geekbrains.lesson_8;

public interface MessageReciever {
    void submitMessage(TextMessage message);
    void userConnected(String login);
    void userDisconnected(String login);
}
