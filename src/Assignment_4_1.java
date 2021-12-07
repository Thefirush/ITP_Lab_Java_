import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Assignment_4_1 {
    public static void main(String[] args) throws FileNotFoundException {

        File fileInput = new File("input.txt");
        File fileOutput = new File("output.txt");

        PrintWriter pw = new PrintWriter(fileOutput);
        Scanner scanner = new Scanner(fileInput);

        String line = null;

        try { //Check for exception number 2
            line = scanner.nextLine();
        } catch (NoSuchElementException ex) {
            pw.print("Exception, file is empty!");
            scanner.close();
            pw.close();
            System.exit(0);
        }

        char[] textChar = line.toCharArray();

        try { //Check for exception number 3
            if (textChar.length > 300) {
                throw new SizeExeption();
            }
        } catch (SizeExeption ex) {
            pw.print("Exception, input exceeds text max size!");
            scanner.close();
            pw.close();
            System.exit(0);
        }
        int lenStr = 0;

        try { //Check for exception number 4
            lenStr = scanner.nextInt();
        } catch (NoSuchElementException ex) {
            pw.print("Exception, intended line width is not specified!");
            scanner.close();
            pw.close();
            System.exit(0);
        }


        try { //Check for exception number 5
            if (lenStr <= 0) {
                throw new WigthExeption();
            }
        } catch (WigthExeption ex) {
            pw.print("Exception, line width cannot be negative or zero!");
            scanner.close();
            pw.close();
            System.exit(0);
        }

        int empty = 0; //Check for exception number 6
        for (char ch: textChar) {
            if (ch == ' ') {
                empty ++;
            } else {
                empty = 0;
            }
            try {
                if ((empty == 2) || (textChar[0] == ' ')) {
                    throw new EmptyExeption();
                }
            } catch (EmptyExeption ex) {
                pw.print("Exception, input contains an empty word!");
                scanner.close();
                pw.close();
                System.exit(0);
            }
        }

        char[] except = new char[] {'.', ',', '!', '?', '-', ':', ';', '(', ')', '\'', '"', ' '};
        ArrayList<Character> chars = new ArrayList<Character>();
        for (int i = 0; i < except.length; i++) { //Check for exception number 7
            chars.add(except[i]);
        }
        for (int i = 0; i < textChar.length; i++) {
            try {
                if (!(Character.isLetter(textChar[i]))) {
                    if (!(chars.contains(textChar[i]))) {
                        throw new SymbolExeption();
                    }
                }
            } catch (SymbolExeption ex) {
                pw.print("Exception, input contains forbidden symbol '" + textChar[i] + "'!");
                scanner.close();
                pw.close();
                System.exit(0);
            }
        }

        String[] words = line.split(" "); // Creating an array of words from source text
        ArrayList<ArrayList<String>> stroki = new ArrayList<>();

        for (int i = 0; i < words.length; i++) { //Check for exception number 8
            try {
                if (words[i].length() > 20) {
                    throw new SizeExeption();
                }
            } catch (SizeExeption ex) {
                pw.print("Exception, '"+ words[i] + "' exceeds the limit of 20 symbols!");
                scanner.close();
                pw.close();
                System.exit(0);
            }
        }

        for (int i = 0; i < words.length; i++) { //Check for exception number 9
            try {
                if (words[i].length() > lenStr) {
                    throw new SizeExeption();
                }
            } catch (SizeExeption ex) {
                pw.print("Exception, '"+ words[i] + "' exceeds " + lenStr + " symbols!");
                scanner.close();
                pw.close();
                System.exit(0);
            }
        }

        // Creating an arraylist from strings and the words they contain
        int slovVStrok = 0;
        int dostupno = lenStr;
        ArrayList<String> stroka = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int razn = dostupno - words[i].length();
            if (razn - slovVStrok >= 0) {
                stroka.add(words[i]);
                dostupno = dostupno - words[i].length();
                slovVStrok ++;
            } else {
                stroki.add(new ArrayList<>(stroka));
                slovVStrok = 1;
                stroka.clear();
                stroka.add(words[i]);
                dostupno = lenStr - words[i].length();
            }
        }
        stroki.add(new ArrayList<>(stroka));

        // Formatting text output by checking the number of spaces available
        for (int i = 0; i < stroki.size(); i++) {
            int n = 0;
            int f = 0;

            int sumLengthWord = 0;
            for (int k = 0; k < stroki.get(i).size(); k++) {
                sumLengthWord += stroki.get(i).get(k).length();
            }

            for (int j = 0; j < stroki.get(i).size(); j++) {
                pw.print(stroki.get(i).get(j));
                if ((i != stroki.size() - 1) & (stroki.get(i).size() != 1) & (j != stroki.get(i).size() - 1)) {
                    if ((lenStr - sumLengthWord) % (stroki.get(i).size() - 1) == 0) {
                        for (int m = 0; m < (lenStr - sumLengthWord) / (stroki.get(i).size() - 1); m++) {
                            pw.print(" ");
                        }
                    } else if ((lenStr - sumLengthWord) % (stroki.get(i).size() - 1) == 1) {
                        if (n == 0) {
                            for (int m = 0; m < ((lenStr - sumLengthWord) / (stroki.get(i).size() - 1)) + 1; m++) {
                                pw.print(" ");
                            }
                            n += 1;
                        } else {
                            for (int m = 0; m < ((lenStr - sumLengthWord) / (stroki.get(i).size() - 1)); m++) {
                                pw.print(" ");
                            }
                        }
                    } else if ((lenStr - sumLengthWord) % (stroki.get(i).size() - 1) == 2) {
                        if (f < 2) {
                            for (int m = 0; m < ((lenStr - sumLengthWord) / (stroki.get(i).size() - 1)) + 1; m++) {
                                pw.print(" ");
                            }
                            f += 1;
                        } else {
                            for (int m = 0; m < ((lenStr - sumLengthWord) / (stroki.get(i).size() - 1)); m++) {
                                pw.print(" ");
                            }
                        }
                    }
                } else {
                    if (j != stroki.get(i).size()-1) {
                        pw.print(" ");
                    }
                }
            }
            pw.print("\n");
        }


        scanner.close();
        pw.close();
    }
}

// Creating personal exceptions

class SymbolExeption extends Exception {
}

class WigthExeption extends Exception {
}

class SizeExeption extends Exception {
}

class EmptyExeption extends Exception {
}
