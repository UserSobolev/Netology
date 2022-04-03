package account;

public class CheckingAccount extends Account{

    public CheckingAccount(int accountBalance) {
        this.accountBalance = accountBalance;
        this.title = "Рассчетный счет";
    }

    @Override
    public boolean pay(int amount) {
        if (amount > this.accountBalance) {
            return false;
        } else {
            accountBalance -= amount;
            System.out.format("Списано %sр. с \"%s\"%n", amount, title);
            return true;
        }
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
        System.out.format("\"%s\" Пополнен на %sр.%n", title, amount);
        return true;
    }
}
