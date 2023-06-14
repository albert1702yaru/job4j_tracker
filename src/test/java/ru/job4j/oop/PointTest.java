package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {

    @Test
    void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double rsl = a.distance(b);
        double expected = 2;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 2, 2);
        double rsl = a.distance3d(b);
        double expected = 3.464;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}