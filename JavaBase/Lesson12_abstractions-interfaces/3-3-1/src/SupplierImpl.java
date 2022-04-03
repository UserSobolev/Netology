public class SupplierImpl extends User implements Supplier{

    public SupplierImpl(String name) {
        super(name);
    }

    @Override
    public void supplyBookToLibrary(String book, User user) {
        //TODO  создать объект типа Book c полем title = book и добавить книгу в массив библиотеки
        System.out.format("Я поставщик %s привез новую книгу -  \"%s\" и отдал библиотекарю %s%n", name, book, user.getName());
    }
}
