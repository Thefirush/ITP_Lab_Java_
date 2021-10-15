import java.util.ArrayList;
import java.util.Objects;

public class Lab7_ex2 {
    public static void main(String[] args) {
        Abst abs = new Abst();
        abs.main();
    }
}

abstract class Creature {
    abstract void bear();
    abstract void die();
    String name = null;
    boolean isAlive = false;
    public void shoutName(){
        System.out.println(Objects.requireNonNullElse(name, "Error"));
    }
}

class Human extends Creature{
    public Human(String name) {
        this.name = name;
    }

    @Override
    void bear() {
        System.out.println(getClass().getSimpleName() + " called " + name + " has born");
    }

    @Override
    void die() {
        System.out.println(getClass().getSimpleName() + " called " + name + " has died");
    }
}

class Dog extends Creature{
    public Dog(String name) {
        this.name = name;
    }
    @Override
    void bear() {
        System.out.println(getClass().getSimpleName() + " called " + name + " has born");
    }

    @Override
    void die() {
        System.out.println(getClass().getSimpleName() + " called " + name + " has died");
    }
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Alien extends Creature{
    public Alien(String name) {
        this.name = name;
    }
    @Override
    void bear() {
        System.out.println(getClass().getSimpleName() + " called " + name + " has born");
    }

    @Override
    void die() {
        System.out.println(getClass().getSimpleName() + " called " + name + " has died");
    }
}

class Abst {
    public void main() {
        ArrayList<Creature> arayshka = new ArrayList<>();
        arayshka.add(new Human("Mike"));
        arayshka.add(new Dog("Bob"));
        arayshka.add(new Alien("Biba"));
        for (int i = 0; i < arayshka.size(); i++) {
            arayshka.get(i).bear();
            arayshka.get(i).die();
        }
    }
}