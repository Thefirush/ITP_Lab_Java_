public class Lab5_ex3_1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 45, 3, 8, 5, 6, 13, 2};
        System.out.println("Average value of array = " + aver(arr));
    }
    static int aver(int[] arr) {
        int sum = 0, av;
        for (int i : arr)
            sum += i;
        av = sum / arr.length;
        return av;
    }
}
