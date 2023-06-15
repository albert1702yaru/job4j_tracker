package ru.job4j.pojo;

public class Library {
    public static void bookPrint(Book[] books) {
        for (Book lib : books) {
            System.out.println("Книга " + lib.getNameBook() + " содержит "
                    + lib.getPages() + " страниц");
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("book1", 100);
        Book book2 = new Book("book2", 185);
        Book book3 = new Book("book3", 345);
        Book cleanCode = new Book("Clean code", 234);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        bookPrint(books);
        books[0] = book3;
        books[3] = cleanCode;
        bookPrint(books);
        for (Book lib : books) {
            if ("Clean code".equals(lib.getNameBook())) {
                System.out.println("Книга " + lib.getNameBook() + " содержит "
                        + lib.getPages() + " страниц");
            }
        }

    }
}
