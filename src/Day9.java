import java.util.Arrays;

public class Day9 {
    //two-pointer. Find available continuous subarray every time.Complexity: O(n)
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int min = 100000000;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length){
            sum += nums[end];
            while (sum >= s){
                min = Math.min(min,end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return min==100000000?0:min;
    }

    //二分法，复杂度O(nlogn)
    public static int erfen(int s, int[] nums){
        int len = nums.length;
        if (len == 0) return 0;
        int[] sum = new int[len+1];
        sum[0] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i-1] + nums[i-1];
            int edge = i-1;
            while (edge >= 0){
                if (sum[i] - sum[edge] >= s){
                    min = Math.min(min,i-edge);
                    break;
                }
                edge--;
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }

    //给定一个数组，找到最短的连续子数组的长度，使得这个子数组的和大于等于s
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.print(erfen(7,nums));
    }
}
