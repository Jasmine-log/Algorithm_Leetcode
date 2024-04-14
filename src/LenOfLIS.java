// https://leetcode.com/problems/longest-increasing-subsequence/

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LenOfLIS {

    //prev index : -1, 0, 1, 2, ..., n-1
    //cur index   : 0, 1, 2,3 , ..., n

    private int[] nums = null;

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;

        return recursion(-1, 0);
    }

    private int recursion(int prevIndex, int curIndex) {

        //base case:
        if (curIndex >= nums.length) {
            return 0;
        }

        int take = 0;
        if (prevIndex == -1 || nums[curIndex] > nums[prevIndex]) {
            //Take
            take = 1 + recursion(curIndex, curIndex + 1);
        }
        //notTake
        int notTake = 0;
        notTake = recursion(prevIndex, curIndex + 1);

        return Math.max(take, notTake);
    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

            // when
            int actual = lengthOfLIS(nums);

            // then
            assertEquals(4, actual);
        }

        @Test
        public void example2() {
            // given
            int[] nums = {0, 1, 0, 3, 2, 3};

            // when
            int actual = lengthOfLIS(nums);

            // then
            assertEquals(4, actual);
        }

        @Test
        public void example3() {
            // given
            int[] nums = {7, 7, 7, 7, 7, 7, 7};

            // when
            int actual = lengthOfLIS(nums);

            // then
            assertEquals(1, actual);
        }
    }
}
