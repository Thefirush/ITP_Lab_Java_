import java.util.Locale;
public class Lab5_ex1_5 {
    public static void main(String[] args) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
        String str = "Sdfnhokondsewqasvtp";
        int countVow = 0;
        for (int i = 0; i < str.length(); i++) {
            for (char vowel : vowels) {
                if (str.charAt(i) == vowel) {
                    countVow++;
                }
            }
        }
        System.out.println("Number of vowels in given string is " + countVow);
    }
}
