package logger;

import java.io.IOException;
import java.util.logging.*;

public abstract class LogImpl implements Log{
    protected Logger logger;
    protected Handler handler;
    protected Formatter formatter;
    public void setParams(){
        try{
            handler = new FileHandler(filename, true);
            logger.addHandler(handler);
            formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
        }catch (IOException e){
            System.out.println("Ошибка открытия файла с именем "+filename);
            e.printStackTrace();
        }
    }
    @Override
    public void log(String event) {
        logger.info(event);
    }
}
