package ru.job4j.polymorph;

public interface Vehicle extends Fuel {
    int WHEELS = 4;

    void accelerate();

    void brake();

    void steer();

    void changeGear();

    void refill();

    static void getDragCoefficlient() {
        System.out.println("Формула расчета коэффициента аэродинамического сопротивления автомобиля");
    }

    default void chargeBattery() {
        System.out.println("Аккумулятор под капотом. Зарядить.");
    }

}