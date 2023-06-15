package ru.job4j.oop;

public class Hare {
    int f = 1;

    public void tryEat(Ball ball) {
        System.out.println("Встретил колобок зайца");
        ball.tryRun(false);
    }
}
