package banking;

import logger.Logger;
import logger.LoggerFactory;

import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    AccountActions bank = new AccountActions();


    public void help(){

        Logger logger = LoggerFactory.getLogger();

        logger.info("<output>","create : Create a new account");
        logger.info("<output>","deposit : Deposit money on your account");
        logger.info("<output>","withdraw : Withdraw money on your account");
        logger.info("<output>","transfer : Transfer money between two accounts");
        logger.info("<output>","loan : Ask for a loan");
        logger.info("<output>","listloan : Print the list of loans");
        logger.info("<output>","exit : Quit this program");
        logger.info("<output>","help : Print commands");

    }

    public void createAccount() {

        Logger logger = LoggerFactory.getLogger();
        logger.debug("PROGRAM", "User account creation");

        logger.info("<output>", "Enter your account name: ");
        String name = scan.nextLine();

        logger.info("<output>", "Enter your age: ");
        int age = scan.nextInt();
    try{
        bank.newAccount(name, age);
        logger.info("<output>", "Account " + name + " created");}
        catch (AccountException e){}
    }

    public void depositAccount() {

        Logger logger = LoggerFactory.getLogger();

        logger.info("<output>","Enter your account name: ");
        String name = scan.nextLine();

        try {
            Account account = bank.getAccountByName(name);
            logger.info("<output>","Enter amount: ");
            int amount = scan.nextInt();
            account.deposit(amount);
            int credit = account.getCredit();
            logger.info("<output>", "You have deposit "+ amount + " credits");
            logger.info("<output>", "You have actually "+ credit + " credits");
        }catch (WrongNameException e){}
    }

    public void withdrawAccount(){

        Logger logger = LoggerFactory.getLogger();

        logger.info("<output>", "Enter your account name");
        String name = scan.nextLine();


        try {
            Account account = bank.getAccountByName(name);
            logger.info("<output>", "Enter amount: ");
            try {
                int amount = scan.nextInt();

                account.withdraw(amount);
                int credit = account.getCredit();
                logger.info("<output>", "You have withdraw " + amount + " credits");
                logger.info("<output>", "You have actually " + credit + " credits");
            } catch (NotEnoughMoneyException e) {
            }
        } catch (WrongNameException a){}

    }

    public void loan()

    {
        Logger logger = LoggerFactory.getLogger();

        logger.info("<output>", "Enter your account name: ");
        String name = scan.nextLine();

        try {

            Account account = bank.getAccountByName(name);
            logger.info("<output>", "Enter amount: ");
            int amount = scan.nextInt();

            logger.info("<output>", "Enter the loan duration: ");
            int duration = scan.nextInt();

            logger.info("<output>", "Enter the loan rate: ");
            int rate = scan.nextInt();
            account.askLoan(amount, duration, rate);
            logger.info("<output>", "Your loan amount is " + amount + " credits during " + duration + " years with " + rate +"% rate");
            int credit = account.getCredit();
            logger.info("<output>", "You have actually "+ credit + " credits");
        }catch (RefusedException e){}
        catch (WrongNameException a){}

    }

    public void listLoan(){

        Logger logger = LoggerFactory.getLogger();

        logger.info("<output>", "Enter your account name: ");
        String name = scan.nextLine();

        try{
            Account account = bank.getAccountByName(name);
            account.listLoan();
        }catch (IllegalArgumentException e){}
        catch (WrongNameException a){}



    }

    public void transfer() {
        Logger logger = LoggerFactory.getLogger();

        logger.info("<output>", "Enter your account name");
        String sender = scan.nextLine();

        logger.info("<output>", "Enter receiver account name");
        String receiver = scan.nextLine();
        if(receiver == null){logger.error("<output>","Invalid account");}


        try {

            Account account1 = bank.getAccountByName(sender);
            Account account2 = bank.getAccountByName(receiver);
            logger.info("<output>", "Enter amount: ");
            int amount = scan.nextInt();
            AccountActions.transfer(account1,account2,amount);
            logger.info("<output>","Transfer successfull");
        }
        catch (NotEnoughMoneyException e){}
        catch (WrongNameException a){}
    }

    public void menu(){

        help();

        while(true){
            Logger logger = LoggerFactory.getLogger();
            logger.info("<output>","Enter a command: ");
            String command = scan.nextLine();

            if(command == null){
                logger.debug("PROGRAM","EOF");
                logger.debug("PROGRAM","EOF");
                System.out.printf("%n");
                return;

            }
            switch (command.toLowerCase()) {

                case "create":
                    createAccount();
                    break;

                case "deposit":
                    depositAccount();
                    break;

                case "withdraw" :
                    withdrawAccount();
                    break;

                case "loan":
                    loan();
                    break;

                case "listloan":
                    listLoan();
                    break;

                case "transfer":
                    transfer();
                    break;

                case "exit":
                    return;

                case "help":
                    help();
                    break;

                default:

            }
        }


    }

}

