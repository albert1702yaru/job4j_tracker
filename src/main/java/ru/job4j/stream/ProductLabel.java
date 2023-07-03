package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(task -> task.getStandard() - task.getActual() >= 0)
                .filter(task -> task.getStandard() - task.getActual() <= 3)
                .map(task -> new Label(task.getName(), task.getPrice() / 2).toString())
                .collect(Collectors.toList());
    }
}