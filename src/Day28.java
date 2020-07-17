public class Day28 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=target) return i;
        }
        return 0;
    }

    public int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int ans = nums.length;
        while (left <= right){
            int mid = (left + right)/2 + left;
            if (nums[mid] == target) return mid;
            else if (nums[mid]<target) {
                left = mid+1;
            }else {
                ans = mid;
                right = mid-1;
            }
        }
        return ans;
    }
}
