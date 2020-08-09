import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day46 {
    List<String> ans = new ArrayList<>();
    int[] nums = new int[4];
    public List<String> restoreIpAddresses(String s){
        nums = new int[4];
        dfs(s,0,0);
        return ans;
    }
    public void dfs(String s, int seg, int start){
        if (seg == 4){
            if (start == s.length()){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(nums[i]).append(".");
                }
                ans.add(sb.substring(0,sb.length()-1).toString());
            }
            return;
        }

        if (s.length() == start) return;
        if (s.charAt(start) == '0'){
            nums[seg] = 0;
            dfs(s,seg+1,start+1);
        }

        int digit = 0;
        for (int i = start; i < s.length(); i++) {
            digit = digit * 10 + (s.charAt(i) - '0');
            if (digit > 0 && digit <= 0xFF){
                nums[seg] = digit;
                dfs(s,seg+1,i+1);
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Day46 d = new Day46();
        List<String> a = d.restoreIpAddresses("25525511135");
        for (String ans:a){
            System.out.println(ans);
        }
    }
}
