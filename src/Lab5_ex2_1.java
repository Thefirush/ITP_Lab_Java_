import java.util.Scanner;
public class Lab5_ex2_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int far = sc.nextInt();
        System.out.println("Fahrenheit degree: " + far);
        int cel = (far - 32) * 5 / 9;
        System.out.println("Celsius degree: " + cel);
    }
}