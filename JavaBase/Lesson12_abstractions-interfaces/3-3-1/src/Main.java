public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Война и Мир");
        Book book2 = new Book("Преступление и наказание");
        Book book3 = new Book("Зеленая миля");

        Reader ivan = new User("Иван");
        SupplierImpl supplier = new SupplierImpl("Борис");
        AdministratorAndLibrarian admin = new AdministratorAndLibrarian("Николай");

        admin.orderBook("Луч", supplier);
        admin.orderBook("Свет", supplier);
        admin.orderBook("Дождь", supplier);

        System.out.println("--------------------------");

        supplier.supplyBookToLibrary("Свет", admin);

        System.out.println("--------------------------");

        admin.findBook(book1);
        admin.giveBook(ivan, book1);
        ivan.takeBook(book1, admin);
        supplier.takeBook(book2, admin);
        supplier.returnBook(book2);
        admin.returnBook(book3);
        admin.overdueNotification(ivan, book1);















	// write your code here
    }
}
