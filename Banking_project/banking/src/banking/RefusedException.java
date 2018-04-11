package banking;

import logger.Logger;
import logger.LoggerFactory;

public class RefusedException extends Exception {
    public RefusedException() {
        Logger logger = LoggerFactory.getLogger();
        logger.error("<output>", "Refused, error can be rate < 1, your age + loanduration > 70 or you ask for more than 2 loans");
    }
}
