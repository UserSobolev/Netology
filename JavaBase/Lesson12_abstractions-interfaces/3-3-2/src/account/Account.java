package account;

public abstract class Account {

    protected int accountBalance;
    protected String title;

//    public Account(int accountBalance) {
//        this.accountBalance = accountBalance;
//    }

    public abstract boolean pay(int amount);
    public abstract void transfer(Account account, int amount);
    public abstract boolean addMoney(int amount);

    public void showBalance() {
        System.out.format("Балланс \"%s\", составляет %sр.%n", title, accountBalance);
    }
}
