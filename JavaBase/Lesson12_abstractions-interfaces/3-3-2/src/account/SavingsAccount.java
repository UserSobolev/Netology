package account;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountBalance) {
        this.accountBalance = accountBalance;
        this.title = "Сберегательный счет";
    }

    @Override
    public boolean pay(int amount) {
        System.out.format("Это \"%s\", с него нельзя заплатить. %n", title);
        return false;
    }

    @Override
    public void transfer(Account account, int amount) {
        if (amount <= accountBalance && account.addMoney(amount)) {
            accountBalance -= amount;
            System.out.format("Списано %sр. с \"%s\"%n", amount, title);
            System.out.format("Вы перевели \"%s\", c %s на \"%s\" \n", amount, title, account.title);
        } else {
            System.out.println("Операция невозможна");
        }
    }

    @Override
    public boolean addMoney(int amount) {
        accountBalance += amount;
        System.out.format("\"%s\" пополнен на %sр.%n", title, amount);
        return true;
    }
}
