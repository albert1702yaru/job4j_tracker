package ru.job4j.condition;

public class Task54 {
    public static void transform(int number) {
        int flag = 1;
        if (number < 0) {
            number *= -1;
            flag = -1;
        }
        int[] num = {number / 100, number % 100 / 10, number % 10};
        for (int i = 0; i < 3; i++) {
            if ((num[i] % 2 == 0 && number % 2 == 0) || (number % 2 != 0 && num[i] % 2 != 0 && num[i] < 9)) {
                num[i]++;
            } else if ((num[i] > 0 && number % 2 == 0 && num[i] % 2 != 0) || (number % 2 != 0 && num[i] % 2 == 0 && num[i] > 0)) {
                num[i]--;
            }
        }
        System.out.println((num[0] * 100 + num[1] * 10 + num[2]) * flag);
    }

    public static void main(String[] args) {
        transform(408);
    }
}