public class Book {
    public Author author;
    public String title;
    public int qtyPages;
    public int year;

    public Book(String title, Author author, int qtyPages, int year) {
        this.title = title;
        this.author = author;
        this.qtyPages = qtyPages;
        this.year = year;
    }
    //Возвращаем информацию о книге
    public String toString() {
        return "Название: " + title + ", Автор: " + author.name + " " + author.surname + ", Кол-во страниц: "
                + qtyPages + ", Год издания: " + year + "\n";
    }
    //Сравниваем книги
    public boolean equalsBook(Book otherBook) {
        return otherBook.title.equals(title) && (otherBook.author.equals(author));
    }
}
