package banking;

import logger.Logger;
import logger.LoggerFactory;


public class Main {
    public static void main(String[] argc) {
        Logger logger = LoggerFactory.getLogger();
        logger.debug("PROGRAM", "Start banking");
        logger.info("<output>", "Java Banking Project");

    Menu menu = new Menu();
    menu.menu();



    }
}
