import java.util.Arrays;
import java.util.Scanner;
public class Lab5_ex3_2 {
    public static void main(String[] arg){
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(insert(arr)));
    }
    static int[] insert(int[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index to invert from 0 to "+ ((arr.length)-1) +": ");
        int index = sc.nextInt();
        System.out.println("Enter the value to invert");
        int valueInvert = sc.nextInt();
        arr[index - 1] = valueInvert;
        return arr;
    }
}
