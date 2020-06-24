import java.util.Arrays;

public class Day5 {
    //three sum question
    /*The method is sort and two-way pointer, for every nums in the sorted array,
    we enumerate the other two numbers after it, from the left edge and the right edge.
    If the sum now is smaller than the target, move right pointer left (because the array is sorted),
    else if the sum is equal to the target, return the result
    else move left pointer right.
    For every move, update the answer.
    */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 100000000;
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == target) return target;
                if (Math.abs(sum-target)<Math.abs(ans-target)){
                    ans = sum;
                }
                if (sum<target){
                    int next_left = left+1;
                    while (right>next_left && nums[left] == nums[next_left]){
                        next_left++;
                    }
                    left = next_left;
                }else {
                    int next_right = right-1;
                    while (left<next_right && nums[right] == nums[next_right]){
                        next_right--;
                    }
                    right = next_right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.print(threeSumClosest(nums,1));
    }
}
