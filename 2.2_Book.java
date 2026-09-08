public class Book {
    String title;
    String author;
    int publicationYear;

    public Book(){}

    public Book(String author, int publicationYear, String title) {
        this.author = author;
        this.publicationYear = publicationYear;
        this.title = title;
    }
}
