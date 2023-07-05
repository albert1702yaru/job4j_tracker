package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {

    private enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    private enum Value {
        V_6, V_7, V_8
    }

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;

    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                +  '}';
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suits -> Stream.of(Value.values())
                        .map(values ->  new Card(suits, values)))
                .toList()
                .forEach(System.out::println);
    }
}