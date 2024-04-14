import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateImage {
    public void rotate(int[][] matrix) {

        int size = matrix.length;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[j][size - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = arr[i][j];
            }
        }

    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

            //when
            rotate(matrix);

            //then
            int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
            assertArrayEquals(expected, matrix);
        }

        @Test
        public void example2() {
            // given
            int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

            //when
            rotate(matrix);

            //then
            int[][] expected = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
            assertArrayEquals(expected, matrix);
        }
    }

}
