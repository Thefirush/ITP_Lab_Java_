import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab5_ex3_3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,5,5,6};
        System.out.println(Arrays.toString(duplicate(arr)));
    }
    static int[] duplicate(int[] arr) {
        int count = 0;
        int[] duplArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    duplArr[count] = arr[i];
                    count += 1;
                }
            }
        }
        return duplArr;
    }
}
