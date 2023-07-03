package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> nambers = Arrays.asList(1, -10, 0, -35, 14, 11, 122, -10, 0, -4, -100);
        List<Integer> positive = nambers.stream()
                .filter(s -> s > 0).
                collect(Collectors.toList());
        System.out.println(positive);
        positive.forEach(System.out::println);
    }
}
