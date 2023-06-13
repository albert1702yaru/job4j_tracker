package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic rus = new DummyDic();
        System.out.println(rus.engToRus("fksj"));
    }
}
