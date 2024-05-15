import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Integer size = Integer.MAX_VALUE;
        String temp = "";
        for (String str : strs) {
            size = str.length();
            temp = str;
        }

        String prefix = "";
        int isChecked = 0;
        String minPrefix = "";
        for (int i = 0; i < size; i++) {
            isChecked = 0;
            prefix += Character.toString(temp.charAt(i));

            for (String str : strs) {
                if (str.contains(prefix) && str.indexOf(prefix) == 0) {
                    isChecked++;

                    if (isChecked == strs.length)
                        minPrefix = prefix;
                } else
                    break;
            }
        }

        return minPrefix;
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

    public void example3() {
        String[] strs = {"isdog", "racecar", "car"};
        String actual = longestCommonPrefix(strs);
        Assertions.assertEquals("", actual);
    }


}