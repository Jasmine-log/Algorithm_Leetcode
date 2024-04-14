import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Code Link:
public class ReverseString {

    char[] s = null;

    public void reverseString(char[] s) {
        this.s = s;

        int n = s.length;
        char temp = '\0';

        for (int i = 0; i < n / 2; i++) {
            temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }

    public void revereStringTwoPointer(char[] s) {
        this.s = s;

        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            char[] s = {'h', 'e', 'l', 'l', 'o', 'w'};

            //when
            //reverseString(s);
            revereStringTwoPointer(s);

            //then
            char[] expected = {'w', 'o', 'l', 'l', 'e', 'h'};
            assertArrayEquals(expected, s);
        }

        @Test
        public void example2() {
            // given
            char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};

            //when
            //reverseString(s);
            revereStringTwoPointer(s);

            //then
            char[] expected = {'h', 'a', 'n', 'n', 'a', 'H'};
            assertArrayEquals(expected, s);
        }
    }
}