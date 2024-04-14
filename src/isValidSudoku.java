import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class isValidSudoku {

    private static final int SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        //rows
        for (int i = 0; i < SIZE; i++) {
            boolean[] visit = {false, false, false, false, false, false, false, false, false, false};

            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') continue;
                int rowIndex = Character.getNumericValue(board[i][j]);
                if (visit[rowIndex]) {
                    return false;
                } else {
                    visit[rowIndex] = true;
                }
            }
        }

        //cols
        for (int i = 0; i < SIZE; i++) {
            boolean[] visit = {false, false, false, false, false, false, false, false, false, false};

            for (int j = 0; j < SIZE; j++) {
                if (board[j][i] == '.') continue;

                int colIndex = Character.getNumericValue(board[j][i]);
                if (visit[colIndex]) {
                    return false;
                } else {
                    visit[colIndex] = true;
                }
            }
        }

        //sub-boxes
        for (int r = 0; r < SIZE; r += 3) {
            for (int c = 0; c < SIZE; c += 3) {
                boolean[] visit = {false, false, false, false, false, false, false, false, false, false};

                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (board[i][j] == '.') continue;

                        int subIndex = Character.getNumericValue(board[i][j]);
                        if (visit[subIndex]) {
                            return false;
                        } else {
                            visit[subIndex] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                    , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                    , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                    , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                    , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                    , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                    , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                    , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                    , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

            // when
            boolean actual = isValidSudoku(board);

            // then
            assertEquals(true, actual);
        }
        @Test
        public void example2() {
            // given
            char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                    , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                    , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                    , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                    , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                    , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                    , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                    , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                    , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

            // when
            boolean actual = isValidSudoku(board);

            // then
            assertEquals(false, actual);
        }
        @Test
        public void example3() {
            // given
            char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                    {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                    {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                    {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                    {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                    {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                    {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
            ;

            // when
            boolean actual = isValidSudoku(board);

            // then
            assertEquals(false, actual);
        }
    }

}
