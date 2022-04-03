package account;

public class CreditAccount extends Account{

    public CreditAccount(int accountBalance) {
        this.accountBalance = accountBalance;
        this.title = "Кредитный счет";
    }

    @Override
    public boolean pay(int amount) {
        accountBalance -= amount;
        System.out.format("Списано %sр. с \"%s\"%n", amount, title);
        return true;
    }

    @Override
    public void transfer(Account account, int amount) {
        pay(amount);
        account.addMoney(amount);
        System.out.format("Вы перевели \"%s\", c %s на \"%s\" \n", amount, title, account.title);
    }

    @Override
    public boolean addMoney(int amount) {
        if (amount > Math.abs(accountBalance)) {
            System.out.format("Эта сумма болше кредитной задолжности, достаточно внести - %sр.%n",
                    Math.abs(accountBalance));
            return false;
        } else {
            accountBalance += amount;
            System.out.format("\"%s\" пополнен на %sр.%n", title, amount);
            return true;
        }
    }
}
