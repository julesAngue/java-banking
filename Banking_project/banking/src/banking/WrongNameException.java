package banking;

import logger.Logger;
import logger.LoggerFactory;

public class WrongNameException extends Exception{

    public WrongNameException() {
        Logger logger = LoggerFactory.getLogger();
        logger.error("<output>", "This account doesn't exists");
    }
}
