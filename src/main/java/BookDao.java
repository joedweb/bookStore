import java.util.List;

public interface BookDao {

    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int bookId);
    Book getBookByID(int bookId);       //read one book

    List<Book> getAllBooks();           // read all books
}
