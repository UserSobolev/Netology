
public class AdministratorAndLibrarian extends User implements Librarian, Administrator {

    public AdministratorAndLibrarian(String name) {
        super(name);
    }

    @Override
    public void orderBook(String book, SupplierImpl supplier) {
        // TODO:  передать в метод supplyBookToLibrary название книги - book, кототорую заказал библиотекарь
        System.out.format("Я библиотекарь %s, заказал новую книгу \"%s\" у поставщика %s%n", name, book, supplier.name);
    }

    @Override
    public void overdueNotification(Reader reader, Book book) {
        System.out.printf("Читатель %s просрочил возврат книги \"%s\" %n", reader.getName(), book.getTitle());
    }

    @Override
    public void findBook(Book book) {
        //TODO: реализовать поиск нужной книги в массиве
        System.out.format("Админисратор нашел книку %s на полке №5 %n", book.getTitle());
    }

    @Override
    public void giveBook(Reader reader, Book book) {
        //TODO: удалить книгу из массива библиотеки
        System.out.format("Я администратор - %s выдал книгу - \"%s\" читателю - %s%n", name, book.getTitle(),
                reader.getName());
    }
}
