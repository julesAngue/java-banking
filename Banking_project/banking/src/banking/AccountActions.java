package banking;

import logger.LoggerFactory;
import java.util.HashSet;
import java.util.Set;
import logger.Logger;


public class AccountActions {
    private final Logger logger = LoggerFactory.getFileLogger("logger");
    private Set <Account> accounts = new HashSet<>();
    public int numberOfAccount = 0;


    public void newAccount(String name, int age) throws AccountException{

        accounts.add(new Account(name, age));
        numberOfAccount++;
    }


    public Account getAccountByName(String name) throws WrongNameException {
        for(Account account : accounts) {
            if (account.getName().equals(name)) {
                return account;
            }

        }
        throw new WrongNameException();
    }


    public static void transfer(Account sender,Account receiver,int amount) throws NotEnoughMoneyException {

        try {


        sender.withdraw(amount);
        receiver.deposit(amount);
    }catch (NotEnoughMoneyException e){}

}}
