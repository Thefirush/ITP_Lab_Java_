import java.util.Scanner;
public class Lab5_ex2_3 {
    public static void main(String[] args) {
        System.out.println("Please, print the integer value: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.printf("The scanned value: %n" + "in decimal: %d,%n" + "in hexadecimal: %h,%n" + "in binary: %s",
                num, num, Integer.toBinaryString(num));
    }
}
