package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        if (rsl < 0) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        try {
            String[] value = new String[]{"1", "2", "3", "4", "5"};
            System.out.println(indexOf(value, "0"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}