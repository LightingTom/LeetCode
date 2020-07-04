
import java.util.Stack;

public class Day15 {
    //保持栈底为最后没被匹配的右括号的下标
    public static int longestValidParentheses(String s) {
        int longest = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (!stack.isEmpty()){
                    longest = Math.max(longest,i-stack.peek());
                }else{
                    stack.push(i);
                }
            }
        }
        return longest;
    }

    //dp is also available
    //Two situations when the char is ')':
    //if it is like "...()", dp[i] = dp[i-2]+1
    //if it is like "...))", if s[i−dp[i−1]−1]='(', dp[i] = dp[i-1] + dp[i−dp[i−1]−2] + 2
    public static int longestValidParentheses_dp(String s){
        int[] dp = new int[s.length()+1];
        int longest = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){
                    dp[i] = (i>=2)?dp[i-2]+2:2;
                }else if ((i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                longest = Math.max(longest,dp[i]);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        System.out.print(longestValidParentheses(")()())"));
    }
}
