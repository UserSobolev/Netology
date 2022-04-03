import account.Account;
import account.CheckingAccount;
import account.CreditAccount;
import account.SavingsAccount;

public class Main {

    public static void main(String[] args) {
        Account savingsAccount = new SavingsAccount(100_000);
        Account creditAccount = new CreditAccount(0);
        Account checkingAccount = new CheckingAccount(150_000);

//         savingsAccount.showBalance();
//         savingsAccount.addMoney(1000);
//         savingsAccount.showBalance();
//         savingsAccount.pay(300);
//         System.out.println();
//
//         checkingAccount.transfer(savingsAccount, 5000);
//         savingsAccount.showBalance();
//         checkingAccount.showBalance();
//         System.out.println();
//
//         creditAccount.showBalance();
//         creditAccount.pay(5000);
//         creditAccount.showBalance();
//         creditAccount.addMoney(6000);
//         creditAccount.addMoney(4000);
//         creditAccount.showBalance();
//         creditAccount.transfer(savingsAccount, 1100);
//         creditAccount.showBalance();
//         savingsAccount.showBalance();
//         System.out.println();

        creditAccount.pay(5000);
        creditAccount.showBalance();
        checkingAccount.showBalance();
        creditAccount.transfer(checkingAccount, 3000);
        creditAccount.showBalance();
        checkingAccount.showBalance();
    }
}
