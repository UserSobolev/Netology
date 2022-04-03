public interface Administrator {

    void overdueNotification(Reader reader, Book book);
    void findBook(Book book);
    void giveBook(Reader reader, Book book);
}
