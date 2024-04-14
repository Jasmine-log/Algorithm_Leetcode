import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Code Link:
public class Solution {

    public int solution(char[] s) {
        return s.length;
    }

    public char[] solution2(char[] s) {
        return s;
    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            char[] testcase = {'j', 'a', 's', 'm', 'i', 'n', 'e'};

            // when
            int actual = solution(testcase);
            //char[] actual = solution(testcase);

            // then
            assertEquals(7, actual);
        }

        @Test
        public void example2() {
            // given
            char[] testcase = {'j', 'a', 's', 'm', 'i', 'n', 'e'};

            // when
            char[] actual = solution2(testcase);

            // then
            char[] expected = {'j', 'a', 's', 'm', 'i', 'n', 'e'};
            assertArrayEquals(expected, actual);
        }
    }
}