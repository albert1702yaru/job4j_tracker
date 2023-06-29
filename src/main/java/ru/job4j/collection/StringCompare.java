package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String len = left.length() <= right.length() ? left : right;
        for (int i = 0; i < len.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        if (left.length() == right.length()) {
            return 0;
        }
        return left.length() < right.length() ? 0 - right.charAt(left.length()) : left.charAt(right.length());
    }
}