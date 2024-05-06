import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class countAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        int j = 0;

        String str = "11";

        for (int i = 0; i < n - 2; i++) {
            int count = 1;
            String s = "";

            for (j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) == str.charAt(j + 1))
                    count++;
                else {
                    s += Integer.toString(count); // count
                    s += str.charAt(j);           // say
                    count = 1;
                }
            }
            s += Integer.toString(count);
            s += str.charAt(j);
            str = s;
        }
        return str;
    }

    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }

        String st = "11";

        int j = 0;

        for (int i = 0; i < n - 2; i++) {
            int count = 1;
            String s = "";
            for (j = 0; j < st.length() - 1; j++) {
                if (st.charAt(j) == st.charAt(j + 1)) {
                    count++;
                } else {
                    s += Integer.toString(count);
                    s += st.charAt(j);
                    count = 1;
                }
            }
            s += Integer.toString(count);
            s += st.charAt(j);
            st = s;
        }
        return st;
    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            int n = 4;

            // when
            String actual = countAndSay(n);

            // then
            assertEquals("1211", actual);
        }

        @Test
        public void example2() {
            // given
            int n = 1;

            // when
            String actual = countAndSay(n);

            // then
            assertEquals("1", actual);
        }
    }
}
