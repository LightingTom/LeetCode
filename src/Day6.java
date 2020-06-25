import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterInputStream;

public class Day6 {
    public static boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //dp, pay attention!
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.print(wordBreak(s,dict));
    }
}
