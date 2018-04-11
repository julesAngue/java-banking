package banking;

import java.util.ArrayList;
import java.util.List;
import logger.Logger;
import logger.LoggerFactory;


public class Account {

    private String name;
    private int age;
    private int credit;
    private List<Loan> loans;
    int numberofLoans = 0;

    public Account(String name, int age){
        if (age < 0)
            throw new IllegalArgumentException("Please enter a positive value");

        this.name = name;
        this.age = age;
        this.credit = 0;
        loans = new ArrayList<Loan>();

    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCredit(){
        return credit;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public void deposit(int amount)
    {
        if (amount < 0)
            throw new IllegalArgumentException("Negative amount");
        setCredit(getCredit() + amount);

    }

    public void withdraw(int amount) throws NotEnoughMoneyException {

        if (amount < 0)
            throw new IllegalArgumentException("Negative amount");

        int newCredit = (getCredit() - amount);

        if(newCredit < 0)
            throw new NotEnoughMoneyException();
        setCredit(newCredit);


    }
    public void askLoan(int amount, int loanDuration, int rate) throws RefusedException{

        if (rate<1)
                throw new RefusedException();

        if (getAge() + loanDuration > 70)
            throw new RefusedException();

        if (numberofLoans >= 2)
    throw new RefusedException();

    loans.add(new Loan(amount,loanDuration,rate));
    numberofLoans++;
    deposit(amount);
}


    public void listLoan() {

    Logger logger = LoggerFactory.getLogger();

    for(Loan loan : loans) {
        logger.info("<output>", "Loan: " + loan.amount +" credits during "+ loan.loanDuration +" years at "+ loan.rate+"% rate");

    }
    }


    public boolean equals(Object obj){
    return obj instanceof Account && ((Account)obj).name.equals(name);
    }
}