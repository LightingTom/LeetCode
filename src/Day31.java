import java.util.Arrays;

public class Day31 {
    public int[] twoSum_pointer(int[] numbers, int target){
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        while (left < right){
            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            else if (numbers[left] + numbers[right] < target) left++;
            else right--;
        }
        return null;
    }

    public static int[] twoSum_binarySearch(int[] numbers, int target){
        int n = numbers.length;
        for (int i = 0; i < n-1; i++) {
            if (target < numbers[i]) break;
            int t = target - numbers[i];
            int res = bs(Arrays.copyOfRange(numbers,i+1,n),t);
            if (res != -1) return new int[]{i+1,res+i+2};
        }
        return null;
    }

    public static int bs(int[] arr,int target){
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = left + (right-left)/2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,25,75};
        int target = 100;
        twoSum_binarySearch(arr,target);
    }
}
