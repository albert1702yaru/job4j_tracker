package ru.job4j.polymorph;

public class Main {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar();
        sportCar.changeGear();
        sportCar.accelerate();
        sportCar.steer();
        sportCar.brake();
        sportCar.refill();
    }

}