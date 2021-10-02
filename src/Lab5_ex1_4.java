import java.util.Scanner;
public class Lab5_ex1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if (s1.compareTo(s2) == 0) {
            System.out.println("This stings are equal");
        } else {
            System.out.println("This strings are not equal");
        }
    }
}
