package logger;

public class ConsoleLogger implements Logger {

    public void log(String category,String message){
        if (category == "OUTPUT") System.out.println(category+" "+message);
    }

    @Override
    public void debug(String category, String message) {
        log(category,message);
    }

    @Override
    public void info(String category, String message) {
        log(category,message);

    }

    @Override
    public void error(String category, String message) {
        log(category,message);
    }
}
