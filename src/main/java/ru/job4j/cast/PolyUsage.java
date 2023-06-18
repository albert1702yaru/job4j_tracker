package ru.job4j.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle trail = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicles = new Vehicle[]{plane, trail, bus};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
