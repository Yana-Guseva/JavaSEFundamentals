package javase.homework._03._02;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Yana on 25.10.2015.
 */
public class AnswersProperty {
    private ResourceBundle bundle;

    AnswersProperty(Locale locale) {
        bundle = ResourceBundle.getBundle("resources/answers", locale);
    }

    public String getValue(String key) throws UnsupportedEncodingException {
        return new String(bundle.getString(key).getBytes("ISO-8859-1"));
    }
}
