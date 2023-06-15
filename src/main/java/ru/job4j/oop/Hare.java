package ru.job4j.oop;

public class Hare {

    public void tryEat(Ball ball) {
        System.out.println("Встретил колобок зайца");
        ball.tryRun(false);
    }
}
