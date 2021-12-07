public class Final {
    public static void main(String[] args) {
    }
}

class Student {
    private String name;
    private int age;
    private Sex sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    private Student(){
    }

    private Student(String name, int age, Sex sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String toString(){
        return this.name + " " + this.age;
    }

}

enum Sex{
    MALE, FEMALE;
    static Sex oppositeSex(Sex sex){
        if (sex == MALE){
            return FEMALE;
        } else {
            return MALE;
        }
    }
}

interface IntarfaceContainer{
    public void show();
}

abstract class AbstractContainer<T> implements IntarfaceContainer{
    T content;
}

class Container<T> extends AbstractContainer{
    private Container(){
    }
    private Container(T content){
        this.content = content;
    }
    public String toString(){
        return content.toString();
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }
}