package CSC3101;

import java.util.Date;

//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:3
public class lab3 {
    public static void main(String[] args) {
        //q1
        Account account1=new Account(1122,20000);
        account1.setAnnualInterestRate(4.5);
        account1.withdraw(2500);
        account1.deposit(3000);
        System.out.println("Balance:"+account1.getBalance());
        System.out.println("Monthly Interest:"+account1.getMonthlyInterest());
        System.out.println("Date:"+account1.getDateCreated());
        //q2
        CheckingAccount checkingAccount1=new CheckingAccount(1,100,500);
        System.out.println(checkingAccount1);
        SavingsAccount savingsAccount1=new SavingsAccount(1,1000,200);
        System.out.println(savingsAccount1);
    }
}

class Account{
    private int id=0;
    private double balance=0;
    private double annualInterestRate=0;
    private Date dateCreated=new Date();

    public Account(){}
    public Account(int id,double balance){
        this.id=id;
        this.balance=balance;
    }

    public int getId(){return id;}
    public double getBalance(){return balance;}
    public double getAnnualInterestRate(){return annualInterestRate;}
    public void setId(int id){this.id=id;}
    public void setBalance(double balance){this.balance=balance;}
    public void setAnnualInterestRate(double annualInterestRate){this.annualInterestRate=annualInterestRate/100;}
    public Date getDateCreated(){return dateCreated;}

    public double getMonthlyInterestRate(){return annualInterestRate/12;}

    public double getMonthlyInterest(){return balance*getMonthlyInterestRate();}

    public double withdraw(double money){
        balance *= 1 + ((new Date().getTime() - dateCreated.getTime()) / (1000 * 60 * 60 * 24 * 30) * getMonthlyInterestRate());

        if(money>balance){
            System.out.println("Insufficient balance");
            return 0;
        }
        balance-=money;
        return money;
    }

    public void deposit(double money) {
        Date nowTime=new Date();
        balance *= 1 + ((nowTime.getTime() - dateCreated.getTime()) / (1000 * 60 * 60 * 24 * 30) * getMonthlyInterestRate());
        dateCreated=nowTime;//if do not renew balance to add tax delete this statement to keep the original date created time
        balance += money;
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double limit) {
        this.overdraftLimit = limit;
    }

    @Override
    public double withdraw(double money){
        setBalance(getBalance()* 1 + ((new Date().getTime() - getDateCreated().getTime()) / (1000 * 60 * 60 * 24 * 30) * getMonthlyInterestRate()));
        if(money>getBalance()-overdraftLimit){
            System.out.println("Insufficient balance");
            return 0;
        }
        setBalance(getBalance()-money);
        return money;
    }
    @Override
    public String toString() {
        return "Checking Account - ID: " + getId() + ", Balance: " + getBalance() + ", Overdraft Limit: " + overdraftLimit;
    }
}

class SavingsAccount extends Account {
    private double maximumWithdrawalLimit;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int id, double balance, double maxWithdrawalLimit) {
        super(id, balance);
        this.maximumWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getMaximumWithdrawalLimit() {
        return maximumWithdrawalLimit;
    }

    public void setMaximumWithdrawalLimit(double limit) {
        this.maximumWithdrawalLimit = limit;
    }
    @Override
    public double withdraw(double money){
        if(money>maximumWithdrawalLimit){
            System.out.println("can not withdraw");
            return 0;
        }
        return super.withdraw(money);
    }


    @Override
    public String toString() {
        return "Savings Account - ID: " + getId() + ", Balance: " + getBalance() + ", Maximum Withdrawal Limit: " + maximumWithdrawalLimit;
    }
}
