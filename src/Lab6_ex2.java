public class Lab6_ex2 {
    public static void main(String[] args) {

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
    static Book[] library = new Book[10];
}
