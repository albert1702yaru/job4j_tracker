package ru.job4j.oop;

public class Fox {
    int f = 1;

    public void tryEat(Ball ball) {
        System.out.println("Встретил колобок лису");
        ball.tryRun(true);
    }
}
