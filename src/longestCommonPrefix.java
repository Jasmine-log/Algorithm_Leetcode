import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Integer size = Integer.MAX_VALUE;
        String temp = "";
        for (String str : strs) {
            if (size > str.length()) {
                size = str.length();
                temp = str;
            }
        }

        String prefix = "";
        int isChecked = 0;
        String minPrefix = "";
        for (int i = 0; i < size; i++) {
            isChecked = 0;
            prefix += Character.toString(temp.charAt(i));

            for (String str : strs) {
                if (str.indexOf(prefix) == 0) {
                    isChecked++;

                    if (isChecked == strs.length)
                        minPrefix = prefix;
                } else
                    break;
            }
        }
        return minPrefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        String str = strs[0];

        if (strs.length == 1) {
            return str;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!check(strs, str.charAt(i), i))
                return str.substring(0, i);
        }

        return str;
    }
    //function for longestCommonPrefix2
    private boolean check(String[] strs, char c, int index) {
        for (String str : strs) {
            if (str.length() <= index)
                return false;

            if (c != str.charAt(index))
                return false;
        }

        return true;
    }

    @Test
    public void example1() {
        String[] strs = {"flower", "flow", "flight"};
        String actual = longestCommonPrefix(strs);
        Assertions.assertEquals("fl", actual);
    }

    @Test
    public void example2() {
        String[] strs = {"dog", "racecar", "car"};
        String actual = longestCommonPrefix(strs);
        Assertions.assertEquals("", actual);
    }

    @Test
    public void example3() {
        String[] strs = {"isdog", "racecar", "car"};
        String actual = longestCommonPrefix(strs);
        Assertions.assertEquals("", actual);
    }
    @Test
    public void example4() {
        String[] strs = {"flower", "flower", "flower"};
        String actual = longestCommonPrefix(strs);
        Assertions.assertEquals("flower", actual);
    }
    @Test
    public void example5() {
        String[] strs = {"flower"};
        String actual = longestCommonPrefix(strs);
        Assertions.assertEquals("flower", actual);
    }
}