public class Book {

    private int bookId;
    private String title;
    private String author;

    private String genre;
    private double price;


    // constructors


    public Book(int bookId, String title, String author, String genre, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    // constructor with no ID

    public Book(String title, String author, String genre, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }


    // getter and setter
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // to String()
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
