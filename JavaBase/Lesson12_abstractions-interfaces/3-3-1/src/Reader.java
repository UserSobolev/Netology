
public interface Reader {

    void takeBook(Book book, Reader administrator);
    void returnBook(Book book);
    String getName();
}