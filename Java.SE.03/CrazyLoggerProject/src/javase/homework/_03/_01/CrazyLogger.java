package javase.homework._03._01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yana on 24.10.2015.
 */
public class CrazyLogger {
    StringBuilder logger;

    CrazyLogger() {
        logger = new StringBuilder();
    }

    public void addLog(Log log) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm");
        String date = dateFormat.format(log.date);
        String newStringLog = date + " - " + log.message + ";\n";
        logger.append(newStringLog);
    }

    public void searchForDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm");
        String stringDate = dateFormat.format(date);
        String[]  arrayString = logger.toString().split("\n");
        for (String string : arrayString) {
            if (string.contains(stringDate)) {
                System.out.println(string);
            }
        }
    }

    public void searchForMessage(String message) {
        String[]  arrayString = logger.toString().split("\n");
        for (String string : arrayString) {
            if (string.contains(message)) {
                System.out.println(string);
            }
        }
    }

    public void printLogs() {
        System.out.println(logger);
    }
}
