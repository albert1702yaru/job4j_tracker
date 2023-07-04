package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;

    }

    public static void main(String[] args) {
        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        Card[] cards = new Card[suits.length * values.length];
        Stream.of(suits)
                .flatMap(suit1 -> Stream.of(values)
                        .map(value1 -> suit1 + " " + values))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}