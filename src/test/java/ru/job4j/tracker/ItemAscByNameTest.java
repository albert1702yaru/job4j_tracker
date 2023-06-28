package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void compare() {
        List<Item> items = Arrays.asList(
                new Item("Sergey", 30),
                new Item("Aleksandr", 25),
                new Item("Boris", 35),
                new Item("Albert", 40)
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Albert", 40),
                new Item("Aleksandr", 25),
                new Item("Boris", 35),
                new Item("Sergey", 30)
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void compareDesc() {
        List<Item> items = Arrays.asList(
                new Item("Sergey", 30),
                new Item("Aleksandr", 25),
                new Item("Boris", 35),
                new Item("Albert", 40)
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Sergey", 30),
                new Item("Boris", 35),
                new Item("Aleksandr", 25),
                new Item("Albert", 40)
        );
        assertThat(items).isEqualTo(expected);
    }
}