package test;

import banking.Account;

public class TestDeposit {
    Account bank = new Account("testAccount",23);

    void TestDeposit(){

        try {
            bank.deposit(300);
            boolean verif = false;
            try {
                bank.deposit( -50);
            } catch (IllegalArgumentException e) {verif = true; }
            if (verif == false)
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){}
    }
}
