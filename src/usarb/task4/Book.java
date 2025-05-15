package usarb.task4;

public class Book {
    private String title;
    private String author;
    private int year;

    // Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Metoda toString() pentru afișare frumoasă
    @Override
    public String toString() {
        return "Book: \"" + title + "\", Author: " + author + ", Year: " + year;
    }
}
