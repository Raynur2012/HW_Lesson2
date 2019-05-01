package ru.geekbrains.lesson_8.auth;
import ru.geekbrains.lesson_8.User;

public interface AuthService {
    boolean authUser(User user);
}
