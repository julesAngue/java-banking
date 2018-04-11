package banking;

public class Loan {
    public int amount;
    public  int loanDuration;
    public int rate;

    public Loan(int amount, int loanDuration,int rate) {

        if (amount < 0)
            throw new IllegalArgumentException("Negative amount");

        if (loanDuration < 0)
            throw new IllegalArgumentException("Negative loan duration");

        if (rate < 0)
            throw new IllegalArgumentException("Negative rate");

        this.amount = amount;
        this.loanDuration = loanDuration;
        this.rate = rate;


    }
}
