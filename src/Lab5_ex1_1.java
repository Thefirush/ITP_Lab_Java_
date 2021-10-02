import java.util.Scanner;

public class Lab5_ex1_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("a = " + a +" and " + "b = " + b);
        int c = a;
        a = b;
        b = c;
        System.out.println("a = " + a + " and " + "b = " + b);
    }
}

