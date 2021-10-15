import java.util.ArrayList;

public class Lab6_ex2 {
    public static void main(String[] args) {
        Library libi = new Library();
        libi.main();
    }
}

class Author {
    private String nameAuthor;
    private String email;
    private Character gender;
    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
    public String getNameAuthor() {
        return nameAuthor;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setGender(Character gender) {
        this.gender = gender;
    }
    public Character getGender() {
        return gender;
    }
}


class Book extends Author{
    private String name;
    private double price;
    private int qty;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getQty() {
        return qty;
    }
}

class Library {
    public void main() {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        ArrayList<Book> lib = new ArrayList<>();

        book1.setName("Forest");
        book1.setPrice(20);
        book1.setQty(3);
        book1.setNameAuthor("Anna");
        book1.setGender('F');
        book1.setEmail("Aa@mail.ru");

        book2.setName("Dream");
        book2.setPrice(15);
        book2.setQty(6);
        book2.setNameAuthor("Michel");
        book2.setGender('M');
        book2.setEmail("Mis@mail.ru");
        lib.add(book1);
        lib.add(book2);

        for (int i = 0; i < lib.size(); i++) {
            System.out.println(lib.get(i).getNameAuthor());
            System.out.println(lib.get(i).getGender());
            System.out.println(lib.get(i).getEmail());
            System.out.println(lib.get(i).getName());
            System.out.println(lib.get(i).getPrice());
            System.out.println(lib.get(i).getQty());
        }
    }
}
