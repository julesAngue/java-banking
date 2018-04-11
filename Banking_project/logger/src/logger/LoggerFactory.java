package logger;

public class LoggerFactory {


    public static Logger getFileLogger(String message){
        FileLogger logger = new FileLogger("banking.log");
        return logger;
    }

    public static Logger getConsoleLogger(){
        ConsoleLogger logger = new ConsoleLogger();
    return logger;
}
    public static Logger getLogger(){
        String path = "/home/user/Projet_java/test";
        Logger filelogger = new FileLogger(path);
        Logger consolelogger = new ConsoleLogger();
        return new CompositeLogger(filelogger,consolelogger);
    }
}