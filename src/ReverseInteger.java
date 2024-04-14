import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Code Link: https://leetcode.com/problems/reverse-integer/description/
public class ReverseInteger {
    private static final int DIVISOR = 10;

    int reverse(int x) {
        int result = 0;

        if (x < 10 && x > -10) return x;

        while (x != 0) {
            int remainder = x % DIVISOR;
            result = result * DIVISOR + remainder;
            x = (x - remainder) / DIVISOR;

            if (result % DIVISOR != remainder) {
                return 0;
            }
        }
        return result;
    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            int testcase = 123;

            // when
            int actual = reverse(testcase);

            // then
            assertEquals(321, actual);
        }

        @Test
        public void example2() {
            // given
            int testcase = -123;

            // when
            int actual = reverse(testcase);

            // then
            assertEquals(-321, actual);
        }

        public void example3() {
            // given
            int testcase = 120;

            // when
            int actual = reverse(testcase);

            // then
            assertEquals(21, actual);
        }

        @Test
        public void example4() {
            // given
            int testcase = 9;

            // when
            int actual = reverse(testcase);

            // then
            assertEquals(9, actual);
        }

        @Test
        public void example5() {
            // given
            int testcase = 1534236469;

            // when
            int actual = reverse(testcase);

            // then
            assertEquals(0, actual);

            //since integer 9646324351 is too large.
            //int ragne : -2,147,483,648~2,147,483,647
            //result=9, reuslt%10=9, remainder=9
            //result=96, reuslt%10=6, remainder=6
            //result=964, reuslt%10=4, remainder=4
            //result=9646, reuslt%10=6, remainder=6
            //result=96463, reuslt%10=3, remainder=3
            //result=964632, reuslt%10=2, remainder=2
            //result=9646324, reuslt%10=4, remainder=4
            //result=96463243, reuslt%10=3, remainder=3
            //result=964632435, reuslt%10=5, remainder=5

            //The next result shout be 9646324351, but,
            //result=1056389759, reuslt%10=9, remainder=1

        }
    }
}