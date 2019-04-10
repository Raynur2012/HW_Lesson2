package ru.geekbrains.lesson_3.tesk2;

import java.util.*;

public class HW_3_2 {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.addObject("Ivan","89221112233");
        book.addObject("Petr","89291112299");

        System.out.println(book.getNumber("Ivan"));
        System.out.println(book.getNumber("Petr"));
    }
}
