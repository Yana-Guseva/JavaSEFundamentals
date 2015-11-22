package javase.homework._03._03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yana on 26.10.2015.
 */
public class LinkSequence {

    public static boolean checkSequence(String text) {
        String regPicture = "\\([Ðð]èñ\\.\\s?\\d{1,}[^\\)]*\\)";
        String regNumberOfPicture = "\\d{1,}";

        Pattern patternReference = Pattern.compile(regPicture);
        Pattern patternNumberOfPicture = Pattern.compile(regNumberOfPicture);

        int currientNumber = 0;
        Matcher matcher = patternReference.matcher(text);
        while (matcher.find()) {
            String reference = matcher.group();
            Matcher matcherForNumber = patternNumberOfPicture.matcher(reference);
            matcherForNumber.find();
            if (currientNumber > Integer.parseInt(matcherForNumber.group())) {
                return false;
            }
            currientNumber = Integer.parseInt(matcherForNumber.group());
        }
        return true;
    }

    public static void printSentenceWithPicture(String text) {
        String regHtml ="(<[\\/\\!]*?[^<>]*?>)|\\&.+?\\;";
        String regSentence = "(^|(?<=[.!?]\\s))(\\d+\\.\\s?)*[À-ß][^!?]*?[.!?](?=\\s*(\\d+\\.\\s)*[À-ß]|$)";
        String regSentenceWithPicture = "(\\([Ðð]èñ\\.\\s?\\d{1,}[^\\)]*\\)+)";

        Pattern patternSentence = Pattern.compile(regSentence);
        Pattern patternHtml = Pattern.compile(regHtml);
        Pattern patternRegSentenceWithPicture = Pattern.compile(regSentenceWithPicture);

        Matcher matcherHtml = patternHtml.matcher(text);
        String textWithoutHtml = matcherHtml.replaceAll("");
        Matcher matcherSentence = patternSentence.matcher(textWithoutHtml);
        while (matcherSentence.find()) {
            String str = matcherSentence.group();
            Matcher matcherSentenceWithoutPicture = patternRegSentenceWithPicture.matcher(str);
            if (matcherSentenceWithoutPicture.find()) {
                System.out.println(str);
            }
        }
    }
}
