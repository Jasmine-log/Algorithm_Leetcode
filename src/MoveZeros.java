
public class MoveZeros {
    public MoveZeros() {
    }

    void moveZeroes(int[] nums) {
        int[] array = new int[nums.length];
        int count = 0;

        int i;
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                ++count;
            }
        }

        for (i = count; i < nums.length; ++i) {
            nums[i] = 0;
        }

    }
}
