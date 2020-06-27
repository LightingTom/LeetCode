public class Day8 {
    //原地哈希。
    //We don't use extra space to store the information. Instead, we use the original array to store.
    /*Because we can change the corresponding number to negative and the information is still there and we can know
    whether the index number appear by judging its positivity
    */
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = nums.length + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;
            if (num < 6 && nums[num] > 0) nums[num] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }

    //give an array, find the smallest positive integer number which doesn't appear in the array
    //Can only use O(n) time and O(1) extra space
    public static void main(String[] args) {
        int[] nums = {6,8,43,7,9,3,1,7,9,45};
        System.out.print(firstMissingPositive(nums));
    }
}
