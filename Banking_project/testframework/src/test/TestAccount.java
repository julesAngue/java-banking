package test;
import banking.Account;
import banking.Account.*;
import banking.AccountActions;
import banking.AccountException;

public class TestAccount {

    AccountActions bank = new AccountActions();

    void TestAccount(){

        try {
            bank.newAccount("Jules", 20);
            boolean verif = false;
            try {
                bank.newAccount("Florian", -12);
            } catch (AccountException e) {verif = true; }
            if (verif == false)
                throw new AccountException();
            }catch (AccountException e){}
        }


}
