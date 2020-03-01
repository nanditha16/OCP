package com.examOCP.misc.Patterns;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class RegularExpressionConceptsTest {
    private RegularExpressionConcepts m;

    @org.junit.Before
    public void setUp() throws Exception {
        m = new RegularExpressionConcepts();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void isTrueTest() {
        assertTrue(m.isTrue("true"));
        assertFalse(m.isTrue("true2"));
        assertFalse(m.isTrue("True"));
    }

    @Test
    public void isTrueVersion2Test() {
        assertTrue(m.isTrueVersion2("true"));
        assertFalse(m.isTrueVersion2("true2"));
        assertTrue(m.isTrueVersion2("True"));
        ;
    }

    @Test
    public void isTrueOrYesTest() {
        assertTrue(m.isTrueOrYes("true"));
        assertTrue(m.isTrueOrYes("yes"));
        assertTrue(m.isTrueOrYes("Yes"));
        assertFalse(m.isTrueOrYes("no"));
    }

    @Test
    public void containsTrueTest() {
        assertTrue(m.containsTrue("thetruewithin"));
    }

    @Test
    public void isThreeLettersTest() {
        assertTrue(m.isThreeLetters("abc"));
        assertFalse(m.isThreeLetters("abcd"));
    }

    @Test
    public void isNoNumberAtBeginningTest() {
        assertTrue(m.isNoNumberAtBeginning("abc"));
        assertFalse(m.isNoNumberAtBeginning("1abcd"));
        assertTrue(m.isNoNumberAtBeginning("a1bcd"));
        assertTrue(m.isNoNumberAtBeginning("asdfdsf"));
    }

    @Test
    public void isIntersectionTest() {
        assertTrue(m.isIntersection("1"));
        assertFalse(m.isIntersection("abcksdfkdskfsdfdsf"));
        assertTrue(m.isIntersection("skdskfjsmcnxmvjwque484242"));
    }

    @Test
    public void isLessThenThreeHundredTest() {
        assertTrue(m.isLessThenThreeHundred("288"));
        assertFalse(m.isLessThenThreeHundred("3288"));
        assertFalse(m.isLessThenThreeHundred("328 8"));
        assertTrue(m.isLessThenThreeHundred("1"));
        assertTrue(m.isLessThenThreeHundred("99"));
        assertFalse(m.isLessThenThreeHundred("300"));
    }

    // Extra Regular Expression tests using examples:

    // Case 1: if text line contains either the word "Joe" or the word "Jim" or both.
    @Test
    public void testTrueOnEitherOrCheck() {
        String s = "humbapumpa jim";
        assertTrue(s.matches(".*(jim|joe).*"));
        s = "humbapumpa jom";
        assertFalse(s.matches(".*(jim|joe).*"));
        s = "humbaPumpa joe";
        assertTrue(s.matches(".*(jim|joe).*"));
        s = "humbapumpa joe jim";
        assertTrue(s.matches(".*(jim|joe).*"));
    }

    // Case 2: a regular expression which matches any phone number.
    @Test
    public void testTrueOnDigits() {
        String pattern = "\\d{3}([,\\s])?\\d\\d\\d\\d"; // ([,\s])? : may contain space/ dash/ nothing
        String s = "1233323322";     // \\d{3} : 3 digits
        assertFalse(s.matches(pattern));
        s = "1233323";
        assertTrue(s.matches(pattern));
        s = "123 3323";
        assertTrue(s.matches(pattern));

        // Using a method with Pattern class rather than using String.matches()
        s= "1233";
        assertTrue(test(s));
        s= "0";
        assertFalse(test(s));
        s = "29 Kasdkf 2300 Kdsdf";
        assertTrue(test(s));
        s = "99900234";
        assertTrue(test(s));
    }

    /*
         Using PATTERN and Matcher
     */
    private boolean test(String s) {
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return true;
        }
        return false;
    }

}