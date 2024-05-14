import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class myAtoi {

    public int myAtoi(String str) {

        final int len = str.length();

        if (len == 0) return 0;

        int index = 0;

        while (index < len && str.charAt(index) == ' ') ++index;

        boolean isNegative = false;

        if (index < len) {
            if (str.charAt(index) == '-') {
                isNegative = true;
                ++index;
            } else if (str.charAt(index) == '+') {
                ++index;
            }
        }

        int result = 0;

        while (index < len && isDigit(str.charAt(index))) {

            int digit = str.charAt(index) - '0';

            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = (result * 10) + digit;

            ++index;
        }

        return isNegative ? -result : result;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }


    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            String s = "42";

            // when
            int actual = myAtoi(s);

            // then
            assertEquals(42, actual);
        }

        @Test
        public void example2() {
            // given
            String s = "   -042";//"-042"

            // when
            int actual = myAtoi(s);

            // then
            assertEquals(-42, actual);
        }

        @Test
        public void example3() {
            // given
            String s = "1337c0d3";

            // when
            int actual = myAtoi(s);

            // then
            assertEquals(1337, actual);
        }

        @Test
        public void example4() {
            // given
            String s = "0-1";

            // when
            int actual = myAtoi(s);

            // then
            assertEquals(0, actual);
        }

        @Test
        public void example5() {
            // given
            String s = "words and 987";

            // when
            int actual = myAtoi(s);

            // then
            assertEquals(0, actual);
        }

        @Test
        public void example5() {
            // given
            String s = "91283472332";

            // when
            int actual = myAtoi(s);

            // then
            assertEquals(-91283472332, actual);
        }
    }


}
