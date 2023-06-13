package ru.job4j.oop;

public class Error {
    private boolean activ;
    private int status;
    private String message;

    public Error() { }

    public Error(boolean activ, int status, String message) {
        this.activ = activ;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("Наличие ошибки: " + activ);
        System.out.println("Код ошибка: " + status);
        System.out.println("Описание ошибки: " + message);
    }

    public static void main(String[] args) {
        Error errDefault = new Error();
        Error notErr = new Error(false, 0, "Ошибок нет");
        Error err = new Error(true, 1, "Ошибка!");
        errDefault.printError();
        notErr.printError();
        err.printError();
    }
}
