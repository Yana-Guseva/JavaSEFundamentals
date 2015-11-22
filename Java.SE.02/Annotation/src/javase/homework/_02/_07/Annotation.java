package javase.homework._02._07;

import java.lang.annotation.Documented;

/**
 * Created by Yana on 19.10.2015.
 */
@Documented
public @interface Annotation {
    String author();
    String date();
    String lastModified();
}
