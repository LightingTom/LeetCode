@Info(date = "2020-08-03", difficulty = 0, command = "pay attention to the last carry")
public class Day44 {
    public String addStrings(String num1,String num2){
        if (num1.length() < num2.length()){
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num2.length(); i++) {
            int result = (num1.charAt(num1.length()-1-i)-'0') + (num2.charAt(num2.length()-1-i)-'0') + carry;
            carry = result / 10;
            sb.append(result%10);
        }
        for (int i = num1.length()-1-num2.length(); i >= 0; i--) {
            int result = num1.charAt(i) - '0' + carry;
            carry = result / 10;
            sb.append(result % 10);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Day44 a = new Day44();
        System.out.println(a.addStrings("1","9"));
    }
}
