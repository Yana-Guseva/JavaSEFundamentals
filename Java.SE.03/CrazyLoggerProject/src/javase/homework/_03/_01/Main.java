package javase.homework._03._01;

import javase.homework._03._01.CrazyLogger;
import javase.homework._03._01.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Yana on 24.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
        CrazyLogger crazyLogger = new CrazyLogger();
        try {
            crazyLogger.addLog(new Log(format.parse("24-10-2015 : 07-00"), "log1"));
            crazyLogger.addLog(new Log(format.parse("24-10-2015 : 08-00"), "log2"));
            crazyLogger.addLog(new Log(format.parse("24-11-2015 : 07-00"), "log15"));
            crazyLogger.addLog(new Log(format.parse("24-12-2015 : 07-10"), "log3"));
            crazyLogger.addLog(new Log(format.parse("25-12-2015 : 09-00"), "log16"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        crazyLogger.printLogs();

        System.out.println("Search for date: 24-12-2015 : 07-10");
        try {
            crazyLogger.searchForDate(format.parse("24-12-2015 : 07-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("\nSearch for message: log1");
        crazyLogger.searchForMessage("log1");
    }
}
