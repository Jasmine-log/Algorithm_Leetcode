import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Implement strStr
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/

public class strStr {
    public int strStr(String haystack, String needle) {

        if (haystack.length() == needle.length())
            return haystack.equals(needle) ? 0 : -1;

        if (haystack.length() < needle.length())
            return -1;


        // You don't need to use contains() library since it is overlapped!
        int i = 0, j = 0;
        int start = 0;
        int count = 0;

        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                count++;

            } else { //initialize
                start++;
                i = start;
                j = 0;
                count = 0;
            }

            if (count == needle.length()) return start;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if (haystack.length() == needle.length())
            return haystack.equals(needle) ? 0 : -1;

        if (haystack.length() < needle.length())
            return -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (compare(haystack, i, needle)) return i;
        }

        return -1;
    }

    // function for strStr2
    private boolean compare(String haystack, int startIndex, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            int index = startIndex + i;

            if (haystack.charAt(index) != needle.charAt(index)) {
                return false;
            }
        }

        return true;

    }

    //very simple code
    public int strStr3(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            String haystuck = "sadbutsad";
            String needle = "sad";

            // when
            int actual = strStr(haystuck, needle);

            // then
            assertEquals(0, actual);
        }

        @Test
        public void example2() {
            // given
            String haystuck = "leetcode";
            String needle = "leeto";

            // when
            int actual = strStr(haystuck, needle);

            // then
            assertEquals(-1, actual);
        }

        @Test
        public void example3() {
            // given
            String haystuck = "leeto";
            String needle = "leetcode";

            // when
            int actual = strStr(haystuck, needle);

            // then
            assertEquals(-1, actual);
        }

        @Test
        public void example4() {
            // given
            String haystuck = "leeto";
            String needle = "leeto";

            // when
            int actual = strStr(haystuck, needle);

            // then
            assertEquals(0, actual);
        }

        @Test
        public void example5() {
            // given
            String haystuck = "leetu";
            String needle = "leeto";

            // when
            int actual = strStr(haystuck, needle);

            // then
            assertEquals(-1, actual);
        }

        @Test
        public void example6() {
            // given
            String haystuck = "abc";
            String needle = "c";

            // when
            int actual = strStr(haystuck, needle);

            // then
            assertEquals(2, actual);
        }

        @Test
        public void example7() {
            // given
            String haystuck = "mississippi";
            String needle = "sipp";

            // when
            int actual = strStr(haystuck, needle);

            // then
            assertEquals(6, actual);
        }

    }
}