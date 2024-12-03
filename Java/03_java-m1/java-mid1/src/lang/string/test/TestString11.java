package lang.string.test;

public class TestString11 {
    public static void main(String[] args) {
        String str = "Hello Java";

        String reversed = new StringBuffer(str).reverse().toString();
        System.out.println(reversed);
    }
}
