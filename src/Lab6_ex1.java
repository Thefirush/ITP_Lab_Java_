import java.util.Scanner;

public class Lab6_ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the operator");
        String operator = sc.nextLine();
        System.out.println("Enter the first number");
        int a = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();
        Calculator calculator = new Calculator(a, b);

        switch (operator) {
            case "+" :
                System.out.println(calculator.add(a,b));
                break;
            case "-" :
                System.out.println(calculator.sub(a,b));
                break;
            case "*" :
                System.out.println(calculator.mult(a,b));
                break;
            case "/" :
                if (calculator.div(a,b) % 1 == 0) {
                    b = (int) calculator.div(a,b);
                    System.out.println(b);
                } else {
                    System.out.println(calculator.div(a,b));
                }
        }
    }
}

class Calculator{
    private int firstNum;
    private int secondNum;
    public Calculator(int a, int b){
        firstNum = a;
        secondNum = b;
    }
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public int mult(int a, int b) {
        return a * b;
    }
    public float div(int a, int b) {
        if (b == 0)
            return -1;
        else
            return (float) a / b;
    }
}
