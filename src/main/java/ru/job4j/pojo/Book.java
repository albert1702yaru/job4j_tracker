package ru.job4j.pojo;

public class Book {

    private String nameBook;
    private int pages;

    public Book(String name, int pages) {
        this.nameBook = name;
        this.pages = pages;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
