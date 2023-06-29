package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenComparatorByName() {
        int rsl = new JobByName().compare(
                new Job("Alex", 0),
                new Job("Boris", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorByPriority() {
        int rsl = new JobByPriority().compare(
                new Job("Alex", 8),
                new Job("Boris", 9)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorDestByName() {
        int rsl = new JobByName().compare(
                new Job("Alex", 0),
                new Job("Boris", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorDestByPriority() {
        int rsl = new JobByPriority().compare(
                new Job("Alex", 8),
                new Job("Boris", 9)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

}