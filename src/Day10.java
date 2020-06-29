import java.util.Arrays;

public class Day10 {
    //Too easy
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
