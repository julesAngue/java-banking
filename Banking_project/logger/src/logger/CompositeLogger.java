package logger;

public class CompositeLogger implements Logger {

    private Logger fileLogger;
    private Logger logger;

    public CompositeLogger(Logger logger, Logger fileLogger) {
        this.fileLogger = fileLogger;
        this.logger = logger;
    }

    public void debug(String category, String message) {
        logger.debug(category, message);
        fileLogger.debug(category,message);
    }
    public void info(String category, String message) {
        logger.info(category, message);
        fileLogger.info(category,message);
    }
    public void error(String category, String message) {
        logger.error(category, message);
        fileLogger.error(category,message);
    }
}
