package ru.geekbrains.lesson_3.tesk2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    Map<List<String>,String> phoneBook = new HashMap<>();
    List<String> names = new ArrayList<>();

    public void addObject(String name, String number){
        names.add(name);
        phoneBook.put(names,number);
    }
    public String getNumber(String name){
        return phoneBook.get(names);
    }
}
