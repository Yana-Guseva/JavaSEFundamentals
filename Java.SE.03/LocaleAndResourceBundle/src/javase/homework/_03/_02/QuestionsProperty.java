package javase.homework._03._02;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Yana on 25.10.2015.
 */
public class QuestionsProperty {
    private ResourceBundle bundle;

    QuestionsProperty(Locale locale) {
        bundle = ResourceBundle.getBundle("resources/questions", locale);
    }

    public String getValue(String key) throws UnsupportedEncodingException {
        return new String(bundle.getString(key).getBytes("ISO-8859-1"));
    }

    public void getAllValues() throws UnsupportedEncodingException {
        for (Enumeration<String> allKeys = bundle.getKeys(); allKeys.hasMoreElements();) {
            System.out.println(getValue(allKeys.nextElement()));
        }
    }
}
