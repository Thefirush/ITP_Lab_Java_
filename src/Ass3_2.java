import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ass3_2 {
    public static void main(String[] args) throws FileNotFoundException {
        File fileInput = new File("input.txt");
        File fileOutput = new File("output.txt");
        PrintWriter pw = new PrintWriter(fileOutput);

        Scanner scanner = new Scanner(fileInput);

        String line = scanner.nextLine();
        char[] charArray = line.toCharArray();

        StringBuilder hours = new StringBuilder ("");
        StringBuilder minutes = new StringBuilder ("");

        for (int i = 0; i < 2; i++) {
            hours.append(charArray[i]);
        }

        for (int i = 3; i < 5; i++) {
            minutes.append(charArray[i]);
        }

        String hours1 = hours.toString();
        String minutes1 = minutes.toString();

        int h = Integer.parseInt(hours1);
        int m = Integer.parseInt(minutes1);

        if (h < 0 || h > 23 || m < 0 || m > 59) {
            pw.println("Wrong format");
            pw.close();
            System.exit(0);
        }

        if (h > 11) {
            h = h - 12;
        }

        scanner.close();

        int angle = 0;
        int oneMin = 360/60;
        int oneHour = 360/12;
        int angleMin = oneMin * m;
        int angleHour = oneHour * h;
        if ( angleHour > angleMin) {
            angle = angleHour - angleMin;
        } else {
            angle = angleMin - angleHour;
        }
        if (angle > 180) {
            angle = 360 - angle;
        }

        pw.println(angle);

        pw.close();
    }
}
