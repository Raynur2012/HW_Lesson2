package ru.geekbrains.lesson_3.tesk1;

import java.util.*;

public class HW_3_1 {
    public static void main(String[] args) {
        String[] arr = {"Rick", "Morty","Arnold", "Stiuy","Arnold", "Homer", "Bard", "Bender", "Morty", "Morty", "Rick", "Arnold"};
        System.out.println(Arrays.toString(arr));

        Set<String> unique = new LinkedHashSet<>();
        unique.addAll(Arrays.asList(arr));
        System.out.println(unique);

        Map<String, Integer> map = new HashMap<>();
//        int n = 1;
        for (String name : arr) {
            int n = 1;
            if (map.containsKey(name)) {
                n = map.get(name)+1;
            }
            map.put(name,n);

        }
        System.out.println(map);//"%s повторяется %d раз %n", name, n);
    }
}

