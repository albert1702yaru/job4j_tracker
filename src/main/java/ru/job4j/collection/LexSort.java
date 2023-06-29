package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int o1 = Integer.parseInt(left.split(". ")[0]);
        int o2 = Integer.parseInt(right.split(". ")[0]);
        return Integer.compare(o1, o2);
    }
}
