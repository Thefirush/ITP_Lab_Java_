import java.util.ArrayList;

public class Lab7_ex3 {
    public static void main(String[] args) {
        InterfaceDemonstration interfaceDemonstration = new InterfaceDemonstration();
        interfaceDemonstration.main();

    }
}

interface Swimmable {
    void swim();
    void stopSwimming();
}

interface Flyable {
    void fly();
    void stopFlying();
}

interface Living{
    default void live(){
        System.out.println(getClass().getSimpleName() + " lives");
    }
}

class Submarine implements Swimmable {

    @Override
    public void swim() {
        System.out.println(getClass().getSimpleName() + " is swimming");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getClass().getSimpleName() + " stop swimming");

    }
}
class Animals implements Living{
}

class Duck extends Animals implements Swimmable, Living {

    @Override
    public void swim() {
        System.out.println(getClass().getSimpleName() + " is swimming");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getClass().getSimpleName() + " stop swimming");
    }
}

class Penguin extends Animals implements Swimmable, Living {

    @Override
    public void swim() {
        System.out.println(getClass().getSimpleName() + " is swimming");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getClass().getSimpleName() + " stop swimming");
    }
}

class InterfaceDemonstration {
    public void main() {
        ArrayList<Animals> animals = new ArrayList<Animals>();
        Duck duck = new Duck();
        Penguin penguine = new Penguin();
        animals.add(duck);
        animals.add(penguine);
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).live();
        }
    }
}