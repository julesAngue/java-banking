package banking;
import logger.Logger;
import logger.LoggerFactory;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(){
        Logger logger = LoggerFactory.getLogger();
        logger.error("<output>","Not enough money in your account");
    }

}
