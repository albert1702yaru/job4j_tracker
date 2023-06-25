package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer res = null;
        for (int i = 0; i < count; i++) {
            res = queue.poll();
        }
        return res.name();
    }

    public String getFirstUpsetCustomer() {
        Customer res = null;
        for (int i = 0; i <= count; i++) {
            res = queue.poll();
        }
        return res.name();
    }
}