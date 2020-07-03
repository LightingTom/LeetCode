import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = Arrays.copyOfRange(a,0,2);
        System.out.print(b.length);
    }

}
