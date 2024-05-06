import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class isAnagram {

    public boolean isAnagram(String s, String t) {

        int[] ascii = new int[26];

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++)
            ascii[s.charAt(i) - 'a']++;


        for (int i = 0; i < t.length(); i++) {

            if (ascii[t.charAt(i) - 'a'] == 0)
                return false;

            ascii[t.charAt(i) - 'a']--;
        }

        return true;
    }


    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            String s = "anagram";
            String t = "nagaram";

            // when
            boolean actual = isAnagram(s, t);

            // then
            assertEquals(true, actual);
        }

        @Test
        public void example2() {
            String s = "rat";
            String t = "car";

            // when
            boolean actual = isAnagram(s, t);

            // then
            assertEquals(false, actual);
        }


        @Test
        public void example3() {
            String s = "ab";
            String t = "a";

            // when
            boolean actual = isAnagram(s, t);

            // then
            assertEquals(false, actual);
        }
    }


}
