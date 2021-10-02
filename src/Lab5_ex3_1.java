public class Lab5_ex3_1 {
    public void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int sum = 0, count = 0;
        for (int i : arr) {
            sum += i;
            count += 1;
        }
        System.out.println("Average value of array = " + sum/count);
    }
}
