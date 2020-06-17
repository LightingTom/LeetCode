public class Day2 {
    public static int maxScoreSightseeingPair(int[] A) {
        int max = A[0];
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans,max+A[i]-i);
            if (max<(A[i]+i)) max = A[i] + i;
        }
        return ans;
    }

    //Like DP but not.
    public static void main(String[] args) {
        int[] a = {6,7,3,9,5,4,3,2,1,3};
        System.out.print(maxScoreSightseeingPair(a));
    }
}
