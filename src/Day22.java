import java.util.*;

public class Day22 {
    private int[] c;
    private int[] a;

    //树状数组，需要学习，用于动态维护前缀和的问题
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        c = new int[nums.length + 5];
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getID(nums[i]);
            result.add(query(id - 1));
            update(id);
        }
        Collections.reverse(result);
        return result;
    }

    public void discrete(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        a = new int[set.size()];
        int i = 0;
        for (int num : set) {
            a[i++] = num;
        }
        Arrays.sort(a);
    }

    public int lowBit(int x) {
        return x & (-x);
    }

    public void update(int pos){
        while (pos<c.length){
            c[pos]++;
            pos += lowBit(pos);
        }
    }

    public int query(int pos){
        int ret = 0;
        while (pos > 0){
            ret += c[pos];
            pos -= lowBit(pos);
        }
        return ret;
    }

    public int getID(int x){
        return Arrays.binarySearch(a,x)+1;
    }
    public static void main(String[] args) {
        System.out.println('2');
    }
}
