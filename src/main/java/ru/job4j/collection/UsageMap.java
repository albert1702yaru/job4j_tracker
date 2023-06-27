package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("albert1702@ya.ru", "Иванов Иван Иванович");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("albert1702@ya.ru", "Исманский Альберт Анатольевич");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
