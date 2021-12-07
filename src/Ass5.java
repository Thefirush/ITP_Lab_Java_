import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Ass5 {
    public static void main(String[] args) throws FileNotFoundException {
        File fileInput = new File("input.txt");
        File fileOutput = new File("output.txt");
        PrintWriter pw = new PrintWriter(fileOutput);
        Scanner scanner = new Scanner(fileInput);

        String lineFirst = scanner.nextLine(); // creating the array of operations
        String[] line1 = lineFirst.split(" ");
        int[] operations = new int[line1.length];
        for (int i = 0; i < operations.length; i++) {
            try{
                operations[i] = Integer.parseInt(line1[i]);
            } catch (NumberFormatException ex){
                pw.print("Exception: Invalid data");
                scanner.close();
                pw.close();

                System.exit(0);
            }
        }
        for (int i = 0; i < operations.length; i++) {
            try {
                if (operations[i] >=  7 || operations[i] < 1) {
                    throw new OperationExeption();
                }
            } catch (OperationExeption ex) {
                pw.print("Exception: Non-existing operation");
                scanner.close();
                pw.close();
                System.exit(0);
            }
        }
        try {
            if (operations.length > 10 || operations.length < 1) {
                throw new Size1Exeption();
            }
        } catch (Size1Exeption ex) {
            pw.print("Exception: The list of operations has an invalid length");
            scanner.close();
            pw.close();
            System.exit(0);
        }
        String lineSecond = scanner.nextLine(); // creating the array of numbers
        String[] line2 = lineSecond.split(" ");
        try {
            if (line2.length > 20 || line2.length < 1) {
                throw new Size1Exeption();
            }
        } catch (Size1Exeption ex) {
            pw.print("Exception: The list of numbers has an invalid length");
            scanner.close();
            pw.close();
            System.exit(0);
        }

        ArrayList<Number> numbers = new ArrayList<Number>();
        for (int i = 0; i < line2.length; i++) {
            if (line2[i].toCharArray()[line2[i].length() - 1] == 'L' || line2[i].toCharArray()[line2[i].length() - 1] == 'l') {
                line2[i] = line2[i].substring(0, line2[i].length() - 1);
                try{
                    long num = Long.parseLong(line2[i]);
                    numbers.add(num);
                } catch (NumberFormatException ex){
                    pw.print("Exception: Invalid data");
                    scanner.close();
                    pw.close();
                    System.exit(0);
                }
            }
            else if (line2[i].toCharArray()[line2[i].length() - 1] == 'F' || line2[i].toCharArray()[line2[i].length() - 1] == 'f') {
                line2[i] = line2[i].substring(0, line2[i].length() - 1);
                try{
                    float num = Float.parseFloat(line2[i]);
                    System.out.println(num);
                    if (!(num + "").equals(line2[i])) {
                        throw new NumberFormatException("overflow");
                    }
                    numbers.add(num);
                } catch (NumberFormatException ex){
                    pw.print("Exception: Invalid data");
                    scanner.close();
                    pw.close();
                    System.exit(0);
                }
            }
            else if (line2[i].toCharArray()[line2[i].length() - 1] == 'I' || line2[i].toCharArray()[line2[i].length() - 1] == 'i') {
                line2[i] = line2[i].substring(0, line2[i].length() - 2);
                try{
                    BigInteger num = new BigInteger(line2[i]);
                    numbers.add(num);
                } catch (NumberFormatException ex){
                    pw.print("Exception: Invalid data");
                    scanner.close();
                    pw.close();
                    System.exit(0);
                }
            }
            else if (line2[i].toCharArray()[line2[i].length() - 1] == 'D' || line2[i].toCharArray()[line2[i].length() - 1] == 'd') {
                line2[i] = line2[i].substring(0, line2[i].length() - 2);
                try{
                    BigDecimal num = new BigDecimal(line2[i]);
                    numbers.add(num);
                } catch (NumberFormatException ex){
                    pw.print("Exception: Invalid data");
                    scanner.close();
                    pw.close();
                    System.exit(0);
                }
            }
            else {
                boolean point = false;
                for (int j = 0; j < line2[i].length(); j++) {
                    char[] chari = line2[i].toCharArray();
                    for (int k = 0; k < chari.length; k++) {
                        if (chari[k] == '.') {
                            point = true;
                        }
                    }
                }
                if (point == true) {
                    try{
                        double num = Double.parseDouble(line2[i]);
                        //System.out.println(num);
                        if (!(num + "").equals(line2[i])) {
                            throw new NumberFormatException("overflow");
                        }
                        double num1 = Double.parseDouble(line2[i]);
                        numbers.add(num);
                    } catch (NumberFormatException ex){
                        pw.print("Exception: Invalid data");
                        scanner.close();
                        pw.close();
                        System.exit(0);
                    }
                } else {
                    try{
                        int num = Integer.parseInt(line2[i]);
                        numbers.add(num);
                    } catch (NumberFormatException exe){
                        pw.print("Exception: Invalid data");
                        scanner.close();
                        pw.close();
                        System.exit(0);
                    }
                }
            }
        }

        double div = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i] == 3 && div == 0) {
                try {
                    div = scanner.nextDouble();
                } catch (NoSuchElementException ex) {
                    pw.print("Exception: Invalid data");
                    scanner.close();
                    pw.close();
                    System.exit(0);
                }
            }
        }
        for (int i = 0; i < operations.length; i++) {
            if (operations[i] == 1) {
                double sum = 0;
                for (int j = 0; j < numbers.size(); j++) {
                    sum += numbers.get(j).doubleValue();
                }
                pw.print(sum + "\n");
            }
            else if (operations[i] == 2) {
                double mult = 1;
                for (int j = 0; j < numbers.size(); j++) {
                    mult *= numbers.get(j).doubleValue();
                }
                pw.print(mult + "\n");
            }
            else if (operations[i] == 3) {
                boolean except = false;
                try {
                    if (div == 0) {
                        throw new ZeroExeption();
                    }
                } catch (ZeroExeption ex) {
                    pw.print("Exception: Division by 0");
                    pw.print("\n");
                    except = true;
                }
                if (except != true) {
                    for (int j = 0; j < numbers.size(); j++) {
                        numbers.set(j, numbers.get(j).doubleValue() / div);
                        pw.print(numbers.get(j));
                        if (j != numbers.size() - 1) {
                            pw.print(", ");
                        }
                    }
                    pw.print("\n");
                }
            }
            else if (operations[i] == 4) {
                double sumForAverage = 0;
                double aver = 0;
                for (int j = 0; j < numbers.size(); j++) {
                    sumForAverage += Math.abs(numbers.get(j).doubleValue());
                    aver = sumForAverage / numbers.size();
                }
                pw.print(aver + "\n");
            }
            else if (operations[i] == 5) {
                boolean except = false;
                for (int j = 0; j < numbers.size(); j++) {
                    try {
                        if (numbers.get(j).doubleValue() < 0) {
                            throw new NegativeExeption();
                        }
                    } catch (NegativeExeption negativeExeption) {
                        pw.print("Exception: Square root cannot be calculated for negative value");
                        pw.print("\n");
                        except = true;
                        break;
                    }
                }
                if (except != true) {
                    for (int j = 0; j < numbers.size(); j++) {
                        numbers.set(j, Math.sqrt(numbers.get(j).doubleValue()));
                        pw.print(numbers.get(j));
                        if (j != numbers.size() - 1) {
                            pw.print(", ");
                        }
                    }
                    pw.print("\n");
                }
            }
            else if (operations[i] == 6) {
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(j).doubleValue() < 0) {
                        numbers.remove(numbers.get(j));
                    }
                    pw.print(numbers.get(j));
                    if (j != numbers.size()-1) {
                        pw.print(", ");
                    }
                }
                pw.print("\n");
            }
        }
        scanner.close();
        pw.close();
    }
}


class OperationExeption extends Exception {
}
class Size1Exeption extends Exception {
}
class NegativeExeption extends Exception {
}
class ZeroExeption extends Exception {
}