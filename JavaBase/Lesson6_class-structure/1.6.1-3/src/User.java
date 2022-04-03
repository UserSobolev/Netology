public class User {
    public static int qtyUsers;
    public Book book1;
    public Book book2;
    public String email;
    public String name;
    public String surname;

    public User(String email, String name, String surname, Book book3, Book book4) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.book1 = book3;
        this.book2 = book4;
        qtyUsers++;
    }

    public String toString() {
        return "Имя пользователя: " + name + " " + surname + ", email: " + email + "\n" + "Список книг: " + book1.title + ", " + book2.title + "\n";
    }
}
