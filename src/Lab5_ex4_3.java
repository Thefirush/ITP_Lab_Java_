import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Lab5_ex4_3 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input.txt");
        File file2 = new File("output.txt");
        Scanner sc = new Scanner(file);
        PrintWriter pw = new PrintWriter(file2);

        while (sc.hasNextLine()) {
            pw.println(sc.nextLine());
        }

        pw.close();
        sc.close();
    }
}
