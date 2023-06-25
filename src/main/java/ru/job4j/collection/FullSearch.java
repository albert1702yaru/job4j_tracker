package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public static Set<String> extractNumber(List<Task> tasks) {
        Set<String> result = new HashSet<>();
        for (Task i : tasks) {
            result.add(i.getNumber());
        }
        return result;
    }
}
