package banking;

import logger.Logger;
import logger.LoggerFactory;

public class AccountException extends Exception{

    public AccountException() {

        Logger logger = LoggerFactory.getLogger();
        logger.error("<output>", "User already exists or/and wrong age");
    }


}
