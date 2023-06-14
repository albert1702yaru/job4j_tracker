package ru.job4j.oop;

public class CarMain {

    public static void main(String[] args) {
        Car car = new Car("WV", "Polo");
        Car.Transmission transmission = car.new Transmission();
        Car.Brakes brakes = car.new Brakes();
        Car.TripComputer tripComputer = car.new TripComputer();
        tripComputer.getInfo();
        car.startEngine();
        transmission.accelerate();
        brakes.brake();
    }
}
