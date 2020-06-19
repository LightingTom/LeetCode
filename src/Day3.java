public class Day3 {
    public static boolean isValid(char a){
        if ((a<='z'&&a>='a')|(a>='0'&&a<='9')) return true;
        else return false;
    }
    public static boolean isPalindrome(String s) {
        if (s == null | s.length() == 0) return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left<right){
            while (left<s.length()&&!isValid(s.charAt(left))){
                left++;
            }
            while (right>=0&&!isValid(s.charAt(right))){
                right--;
            }
            if (left>right) break;
            if (s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    //简单的双向指针
    public static void main(String[] args) {
        String a = ".,";
        String b = "Aa123321aa";
        System.out.print(isPalindrome(a));
    }
}
