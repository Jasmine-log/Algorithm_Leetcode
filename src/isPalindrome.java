
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class isPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        } else {
            s = s.toLowerCase();
            byte[] ascii = new byte[s.length()];
            int count = 0;

            int left;
            int right;
            for(left = 0; left < s.length(); ++left) {
                right = s.charAt(left);
                if (right >= 97 && right <= 122 || right >= 48 && right <= 57) {
                    ascii[count++] = (byte)s.charAt(left);
                }
            }

            left = 0;

            for(right = count - 1; left <= right; --right) {
                if (ascii[left] != ascii[right]) {
                    return false;
                }

                ++left;
            }

            return true;
        }
    }

    @Nested
    class UnitTest {
        UnitTest() {
        }

        @Test
        public void example1() {
            String s = "A man, a plan, a canal: Panama";
            boolean actual = isPalindrome.this.isPalindrome(s);
            Assertions.assertEquals(true, actual);
        }

        @Test
        public void example2() {
            String s = "race a car";
            boolean actual = isPalindrome.this.isPalindrome(s);
            Assertions.assertEquals(false, actual);
        }

        @Test
        public void example3() {
            String s = " ";
            boolean actual = isPalindrome.this.isPalindrome(s);
            Assertions.assertEquals(true, actual);
        }

        @Test
        public void example4() {
            String s = "0P";
            boolean actual = isPalindrome.this.isPalindrome(s);
            Assertions.assertEquals(false, actual);
        }
    }
}
