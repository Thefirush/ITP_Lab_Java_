
public class Lab7_ex1 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.areaPrint();
        Rectangle rectangle = new Rectangle(4, 3);
        rectangle.areaPrint();

    }
}

class Animal {
    int height;
    int weight;
    String color;
    public void eat(){
        System.out.println(getClass().getEnclosingClass().getName() + " is eating");
    }
    public void sleep(){
        System.out.println(getClass().getEnclosingClass().getName() + " is sleeping");
    }
    void animalSound(){
    }
}
class Cow extends Animal {
    @Override
    void animalSound() {
        System.out.println("Mooo");
    }
}
class Cat extends Animal {
    @Override
    void animalSound() {
        System.out.println("Meaw");
    }
}

class Dog1 extends Animal {
    @Override
    void animalSound() {
        System.out.println("Whoof");
    }
}

class Circle{
    int radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    void areaPrint () {
        int area = (int) 3.14 * radius;
        System.out.println("Area of "+ getClass().getName()+" equals " + area);
    }
}
class Rectangle {
    int a;
    int b;
    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    void areaPrint () {
        int area = a * b;
        System.out.println("Area of "+ getClass().getName()+" equals " + area);
    }
}
class Triangle {
    int height;
    int base;
    public Triangle(int a, int b) {
        height = a;
        base = b;
    }
    void areaPrint () {
        int area = (int) height * base / 2;
        System.out.println("Area of "+ getClass().getName()+" equals " + area);
    }
}