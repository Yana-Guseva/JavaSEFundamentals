package javase.homework._03._01;

import java.util.Date;

/**
 * Created by Yana on 24.10.2015.
 */
public class Log {
    Date date;
    String message;

    Log(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
