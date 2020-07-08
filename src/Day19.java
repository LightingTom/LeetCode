public class Day19 {
    //leetcode 面试题16.11.
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (longer == shorter) return new int[]{k*shorter};
        int[] result = new int[k+1];
        for(int i = 0;i<=k;i++){
            result[i] = i*longer + (k-i)*shorter;
        }
        return result;
    }
}
