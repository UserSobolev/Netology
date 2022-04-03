public class User implements Reader{

    protected String name;
    // TODO: создать массив(используем коллекции) типа Book, которые находятся у читателя

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeBook(Book book, Reader administrator) {
        // TODO добавить книгу в массив читателя
        System.out.format("%s взял почитать книгу \"%s\" у администратора %s%n", name, book.getTitle(), administrator.getName());
    }

    @Override
    public void returnBook(Book book) {
        // TODO удалить книгу из массива читателя и добавить в массив библиотеки
        System.out.format("%s вернул книгу \"%s\" библиотекарю %n", name, book.getTitle());
    }
}
