import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day24 {
    public int[] intersect(int[] num1, int[] num2) {
        if (num1.length > num2.length) return intersect(num2, num1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num1.length; i++) {
            int cnt = map.getOrDefault(num1[i], 0) + 1;
            map.put(num1[i], cnt);
        }
        int[] result = new int[num1.length];
        int index = 0;
        for (int i = 0; i < num2.length; i++) {
            int cnt = map.getOrDefault(num2[i], 0);
            if (cnt > 0) {
                result[index++] = num2[i];
                cnt--;
                if (cnt>0){
                    map.put(num2[i],cnt);
                }else{
                    map.remove(num2[i]);
                }
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }
}
