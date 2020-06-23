public class Day4 {
    public static String addBinary(String a, String b) {
        String l_str = (a.length() > b.length()) ? a : b;
        String s_str = (l_str.equals(a)) ? b : a;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = s_str.length() - 1; i >= 0; i--) {
            int res = (s_str.charAt(i) - '0') + (l_str.charAt(i + l_str.length() - s_str.length()) - '0') + carry;
            if (res == 0) {
                carry = 0;
                result.append("0");
            } else if (res == 1) {
                carry = 0;
                result.append("1");
            } else if (res == 2) {
                carry = 1;
                result.append("0");
            } else {
                carry = 1;
                result.append("1");
            }
        }
        for (int i = l_str.length() - s_str.length() - 1; i >= 0; i--) {
            int res = (l_str.charAt(i)-'0') + carry;
            if (res == 0) {
                carry = 0;
                result.append("0");
            } else if (res == 1) {
                carry = 0;
                result.append("1");
            } else {
                carry = 1;
                result.append("0");
            }
        }
        if (carry == 1) result.append("1");

        return result.reverse().toString();
    }

    //binary addition, support any size
    public static void main(String[] args) {
        System.out.print(addBinary("1010","1"));
    }
}
