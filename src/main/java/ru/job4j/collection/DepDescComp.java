package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] oo1 = o1.split("/");
        String[] oo2 = o2.split("/");
        if (oo2[0].compareTo(oo1[0]) != 0) {
            return oo2[0].compareTo(oo1[0]);
        }
        for (int i = 1; i < Math.min(oo1.length, oo2.length); i++) {
            if (oo1[i].compareTo(oo2[i]) != 0) {
                return oo1[i].compareTo(oo2[i]);
            }
        }
        if (oo1.length > oo2.length) {
            return 1;
        }
        if (oo1.length < oo2.length) {
            return -1;
        }
        return o2.compareTo(o1);
    }
}