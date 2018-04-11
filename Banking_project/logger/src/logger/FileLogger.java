package logger;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class FileLogger implements Logger{
    private final Path path;


    public FileLogger(String pathAsString){
        path = Paths.get(pathAsString).toAbsolutePath();

    }
    private static String getDate(){
        Date now = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String dateformat = date.format(now);
        return dateformat;
    }

    public void log(String category,String message,String level){

        String date = getDate();
        try{
            Files.write(path, (date +" " +category +" " +level+" "+ message +"\n").getBytes(),APPEND,CREATE);
        }catch (IOException e){
            throw new RuntimeException("Cannot write log message to[" + path + "]",e);
        }
    }

    @Override
    public void debug(String category, String message) {

            log(category,message,"<DEBUG>");
        System.out.println(message);
    }
    public void info(String category,String message){

            log(category,message,"<INFO>");
        System.out.println(message);

    }
    public void error(String category,String message){
            log(category,message,"<ERROR>");
        System.out.println(message);

    }
}
