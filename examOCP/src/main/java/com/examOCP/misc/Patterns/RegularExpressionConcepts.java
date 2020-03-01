package com.examOCP.misc.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionConcepts {

    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    public static void main(String[] arg) {
        System.out.println("Regular Expression Evaluation in Java 8: ");

        // Using String.matches() for simple String
        // stringMatchExample(EXAMPLE_TEST);

        // Using pattern.matcher() for advanced regular expressions
        patternMatchExample(EXAMPLE_TEST);

    }

    private static void patternMatchExample(String exampleTest) {
        Pattern pattern = Pattern.compile("\\w+");

        Matcher matcher = pattern.matcher(EXAMPLE_TEST);

        // check all occurance
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }

        // now create a new pattern and matcher to replace whitespace with tabs
        Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
        System.out.println(matcher2.replaceAll("\t"));
    }

    private static void stringMatchExample(String s) {

//        System.out.println(EXAMPLE_TEST.matches("\\w.*"));
//
//        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
//        System.out.println(splitString.length);// should be 14
//        for (String string : splitString) {
//            System.out.println(string);
//        }
//        // replace all whitespace with tabs
//        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));

        // returns true if the string matches exactly "true"
        isTrue( s);

        // returns true if the string matches exactly "true" or "True"
        isTrueVersion2(s);

        // returns true if the string matches exactly "true" or "True"
        // or "yes" or "Yes"
        isTrueOrYes(s);

        // returns true if the string contains exactly "true"
        containsTrue(s);

        // returns true if the string contains of three letters
        isThreeLetters(s);

        // returns true if the string does not have a number at the beginning
        isNoNumberAtBeginning(s);

        // returns true if the string contains a arbitrary number of characters except b
        isIntersection(s);

        // returns true if the string contains a number less than 300
        isLessThenThreeHundred(s);
    }

    // returns true if the string matches exactly "true"
    public static boolean isTrue(String s){
        return s.matches("true");
    }

    // returns true if the string matches exactly "true" or "True"
    public static boolean isTrueVersion2(String s){
        return s.matches("[tT]rue");
    }

    // returns true if the string matches exactly "true" or "True"
    // or "yes" or "Yes"
    public static boolean isTrueOrYes(String s){
        return s.matches("[tT]rue|[yY]es");
    }

    // returns true if the string contains exactly "true"
    public static boolean containsTrue(String s){
        return s.matches(".*true.*");
    }

    // returns true if the string contains of three letters
    public static boolean isThreeLetters(String s){
        return s.matches("[a-zA-Z]{3}");
        // simpler from for
        // return s.matches("[a-Z][a-Z][a-Z]");
    }

    // returns true if the string does not have a number at the beginning
    public static boolean isNoNumberAtBeginning(String s){
        return s.matches("^[^\\d].*");
    }

    // returns true if the string contains a arbitrary number of characters except b
   public static boolean isIntersection(String s){
        return s.matches("([\\w&&[^b]])*");
    }
    // returns true if the string contains a number less than 300
    public static boolean isLessThenThreeHundred(String s){
        return s.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*");
    }
}
