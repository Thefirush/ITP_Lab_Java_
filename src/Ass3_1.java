import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ass3_1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fileInput = new File("Asda.txt");
        File fileOutput = new File("output.txt");
        PrintWriter pw = new PrintWriter(fileOutput);
        Scanner scanner = new Scanner(fileInput);
        String line = scanner.nextLine();

        char[] charArray = line.toCharArray();

        ArrayList<Integer[]> boxes = new ArrayList<>();

        ArrayList<Integer> box = new ArrayList<>();
        StringBuilder strNum = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) { // СЧИТЫВАНИЕ МАССИВОВ
            if (charArray[i] == '[') {
                box.clear();
            } else if (charArray[i] == ']') {
                int num = Integer.parseInt(strNum.toString());
                box.add(num);
                Integer[] arr = box.toArray(new Integer[0]);
                boxes.add(arr);
            } else if (charArray[i] == ' ') {
                int num = Integer.parseInt(strNum.toString());
                box.add(num);
                strNum.delete(0,10);
            } else {
                strNum.append(charArray[i]);
            }
        }
        Integer[][] boxes1 = boxes.toArray(new Integer[0][0]); // ПЕРЕВОД ArrayList В МАССИВ ИНТОВ

        for (int i = 0; i < boxes1.length; i++) { //СОРТИРОВКА КАЖДОГО МАССИВА
            Arrays.sort(boxes1[i]);
        }

        //System.out.println("Вывод массива\n");
        //for (int i = 0; i < boxes1.length; i++) { //ВЫВОД МАССИВА
        //    for (int j = 0; j < 3; j++) {
        //        System.out.println(boxes1[i][j]);
        //    }
        //}

        for (int k = 0; k < boxes1.length; k++) { //СОРТИРОВКА ПУЗЫРЬКОМ СУММ МАССИВОВ
            for (int i = 0; i < boxes1.length - 1; i++) {
                int sum1 = 0;
                int sum2 = 0;
                for (int j = 0; j < 3; j++) {
                    sum1 += boxes1[i][j];
                    sum2 += boxes1[i + 1][j];
                }
                Integer[] vrem = new Integer[2];

                //System.out.println(i + " проверка\n");
                //System.out.println(sum1 + " " + sum2 + "\n");

                if (sum1 > sum2) {
                    //System.out.println("Меняются");
                    vrem = boxes1[i];
                    boxes1[i] = boxes1[i + 1];
                    boxes1[i + 1] = vrem;
                }
            }
        }

        Integer[] vrem1 = new Integer[2];
        vrem1 = boxes1[0];

        int countAns = 1;
        int count;

        for (int i = 1; i < boxes1.length; i++) {
            count = 0;
            for (int k = 0; k < 3; k++) {
                if (vrem1[k] < boxes1[i][k]) {
                    count += 1;
                }
            }

            if (count == 3) {
                vrem1 = boxes1[i];
                countAns += 1;
            }
        }

        pw.println(countAns);
        scanner.close();
        pw.close();

    }
}
