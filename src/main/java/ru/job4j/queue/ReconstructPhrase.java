package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        int a = evenElements.size();
        for (int i = 0; i < a; i++) {
            if (i % 2 == 0) {
                str.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return String.valueOf(str);
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        while (descendingElements.size() > 0) {
            str.append(descendingElements.pollLast());
        }
        return String.valueOf(str);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}