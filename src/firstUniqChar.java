public class firstUniqChar {
    public static int firstUniqChar(String s) {

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int ascii = ((int) s.charAt(i)) - 97;
            arr[ascii]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int ascii=((int) s.charAt(i)) - 97;
            if (arr[ascii] == 1) return i;
        }
        return -1;
    }
}
