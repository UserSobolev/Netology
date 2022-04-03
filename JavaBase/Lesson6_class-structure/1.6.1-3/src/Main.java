public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Лев", "Толстой", "Россия", 1828);
        Author author2 = new Author("Стивен", "Кинг", "США", 1947);
        Author author3 = new Author("Дмитрий", "Глуховский", "Россия", 1979);

        Book book1 = new Book("Война и мир", author1, 325, 1999);
        Book book2 = new Book("Зеленая Миля", author2, 257, 1399);
        Book book3 = new Book("Метро 2033", author3, 269, 2001);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println("Книги одинаковые - " + book1.equalsBook(book2) + "\n");

        User user1 = new User("Sobolev@mail.ru", "Anton", "Sobolev", book1, book2);
        User user2 = new User("Petrov@mail.ru", "Ivan", "Petrov", book1, book3);
        User user3 = new User("Ivaniv@mail.ru", "Timur", "Ivanov", book2, book3);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println("Количество юзеров: " + User.qtyUsers);
    }
}
