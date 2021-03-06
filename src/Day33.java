public class Day33 {
    //pay attention: if we judge by right, we don't need to judge
    //if it is a sorted array in advance, but if we use left to judge,
    // it is necessary to do that
    public static int minArr(int[] numbers){
        int left = 0;
        int right = numbers.length-1;
        if (numbers[left] < numbers[right]) return numbers[left];
        while (left < right){
            int mid = left + (right - left)/2;
            if (numbers[left] < numbers[right]) return numbers[left];
            if (numbers[left] > numbers[mid]){
                right = mid;
            }else if (numbers[left] < numbers[mid]){
                left = mid+1;
            }else {
                left++;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int a = minArr(new int[]{1,3,5});
        System.out.println(a);
    }
}
