package variable;

public class VarEx {
    public static void main(String[] args) {
        VarEx ex = new VarEx();

        System.out.println("Ex01");
        ex.Ex01();
        System.out.println(" ");
        System.out.println("Ex02");
        ex.Ex02();
        System.out.println(" ");
        System.out.println("Ex03");
        ex.Ex03();
    }

    public void Ex01() {
        int num1 = 4;
        int num2 = 3;

        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
    }

    public void Ex02() {
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        System.out.println("sum = " + sum);
    }

    public void Ex03() {
        long num = 10000000000L;
        System.out.println("num1 = " + num);

        boolean tOrF = true;
        System.out.println("boolean - " + tOrF);
    }
}
