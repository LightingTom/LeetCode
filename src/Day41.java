@Info(date = "2020-07-31", difficulty = 0, command = "so easy")
public class Day41 {
    public int findMagicIndex(int[] nums){
        if (nums == null || nums.length == 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) return i;
        }
        return -1;
    }
}
