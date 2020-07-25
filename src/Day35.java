public class Day35 {
    public static int splitArray(int[] nums, int m){
        if(nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (nums[i] > left) left = nums[i];
        }
        if (m == 1) return right;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (check(nums,mid,m)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[] nums, int target, int m){
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > target){
                sum = nums[i];
                cnt++;
            }else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

    public static void main(String[] args) {
        int ans = splitArray(new int[]{7,2,5,10,8},2);
        System.out.println(ans);
    }
}
