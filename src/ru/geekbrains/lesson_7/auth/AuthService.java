package ru.geekbrains.lesson_7.auth;
import ru.geekbrains.lesson_7.User;

public interface AuthService {
    boolean authUser(User user);
}
