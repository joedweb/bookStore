import java.util.Scanner;

public class BookStoreApp {
    private static BookDao bookDao = new BookDaoImpl(JDBConnection.getConnection());

    public static void main(String[] args) {
        //if want to test if connection with database is working    JDBConnection.getConnection();      //ClassName.MethodToCheckConnection

        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("Welcome to YET ANOTHER book store! ");
        do {
            System.out.println("""
                                 
                    Please enter your option:
                    1) Add new book
                    2) Update a book
                    3) Delete a book
                    4) Display a book
                    5) Display all books
                    6)- EXIT -
                    """);

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;

                case 2:
                    updateBook(sc);
                    break;

                case 3:
                    deleteBook(sc);
                    break;

                case 4:
                    readBookById(sc);
                    break;

                case 5:
                    displayBooks(sc);
                    break;

                case 6:
                    System.out.println("See you later...");
                    break;

                default:
                    System.out.println("No such choice. Try again");
                    break;
            }

        } while (choice != 6);
    }

    private static void displayBooks(Scanner sc) {
        for (Book book : bookDao.getAllBooks()) {
            System.out.println(book);
        }
    }

    private static void readBookById(Scanner sc) {

        System.out.println("Please enter book id ");
        int bookId = sc.nextInt();
        Book book = bookDao.getBookByID(bookId);
        if(book == null){
            System.out.println("No book found.");
        }
        else {
            System.out.println(book);
        }
    }

    private static void deleteBook(Scanner sc) {

        System.out.println(" Enter the id to delete: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        //check if the book is there, if yes then proceed to update
        Book book = bookDao.getBookByID(bookId);

        if(book == null) {
            System.out.println("Book not found");
        }
        else{
            bookDao.deleteBook(bookId);
            System.out.println("Book deleted succesffully");
            // use the delete
        }
    }

    private static void updateBook(Scanner sc) {
        System.out.println(" Enter the id to update: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        //check if the book is there, if yes then proceed to update
        Book book = bookDao.getBookByID(bookId);
        if(book == null) {
            System.out.println("Book not found");
        }
        else{
            System.out.println("Enter your new book information (enter to skip item)");
            System.out.println("Title: ");
            String title = sc.nextLine();
            System.out.println("Author: ");
            String author = sc.nextLine();
            System.out.println("Genre: ");
            String genre = sc.nextLine();
            System.out.println("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine(); //consume line

            book.setTitle(title.isEmpty()? book.getTitle() : title);        // !!! asks if empty(pressed enter). If yes it will keep the same title, if not empty (entered a title) it will update the tile

                            // ^ same as
                    // Boolean emptyAuthor = author.isEmpty;
                    // if(emptyAuthor){
                    //book,setAuthor(book.getAuthor());
                    //} book.setAuthor(author);

            book.setAuthor(author.isEmpty()? book.getAuthor() : author);
            book.setGenre(genre.isEmpty()? book.getGenre() : genre);
            book.setPrice(price == 0 ? book.getPrice() : price);
        }
        }

    private static void addBook (Scanner sc) {
            System.out.println("Please enter Book Title: ");
            String title = sc.nextLine();
            System.out.println("Please enter Book author: ");
            String author = sc.nextLine();
            System.out.println("Please enter Book genre: ");
            String genre = sc.nextLine();
            System.out.println("Please enter Book price: ");
            double price = sc.nextDouble();

            Book book = new Book(title, author, genre, price);
            bookDao.addBook(book);
            System.out.println("Book added successfully");

        }

    }

