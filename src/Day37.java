public class Day37 {
    public boolean isSubsequence(String s, String t){
        char[] ptn = s.toCharArray();
        char[] text = t.toCharArray();

        int cnt = 0;
        for (int i = 0; i < text.length; i++) {
            if (cnt == ptn.length) return true;
            if (ptn[cnt] == text[i]) cnt++;
        }
        if (cnt == ptn.length) return true;
        else return false;
    }
}
