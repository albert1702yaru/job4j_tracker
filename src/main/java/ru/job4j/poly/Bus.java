package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус готов к поездке");
    }

    @Override
    public void passengers(int pass) {
        System.out.println("Пассажиров: " + pass);
    }

    @Override
    public double refuel(int fuel) {
        System.out.println("Автобус заправлен");
        return fuel * 63.35;
    }
}
