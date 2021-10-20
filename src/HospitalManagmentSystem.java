import java.util.Scanner;

public class HospitalManagmentSystem {
    public static void main(String[] args) {
        User user = new User();
        user.main(null);

    }
}

class User {
    public void main(Object object) {
        System.out.println("Main menu.\n Enter your choice:\n1. Receptionist\n2. Patient\n3. Doctor\n4. Exit\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
            switch (choice) {
                case 1:
                    Receptionist R = new Receptionist();
                    R.Choice();
                    break;
                case 2:
                    Patient P = new Patient();
                    P.Choice();
                    break;
                case 3:
                    Doctor D = new Doctor();
                    D.Choice();
                    break;
                case 4:
                    System.exit(0);
            }
        } else {
            System.out.println("Incorrect number of choice");
            System.exit(0);
        }

        System.out.println("Thank you for using our services.\n");
    }
}

class Billing {

    private int b_no = 111;
    private int b_amt = 2222;

    Patient P = new Patient();

    public int getB_no() {
        return b_no;
    }

    public int getB_amt() {
        return b_amt;
    }

    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    public void setB_amt(int b_amt) {
        this.b_amt = b_amt;
    }

    public String getP_name() {
        return P.getP_name();
    }

    public Patient getP() {
        return P;
    }

    public int getP_id() {
        return P.getP_id();
    }
}


class Receptionist extends User {

    private int r_id;
    private String r_name;

    public void Choice() {
        System.out.println("Enter your choice:\n1) GiveAppoint\n2) GenerateBill\n3) Go back\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                GiveAppoint();
                break;
            case 2:
                GenerateBill();
                break;
            default:
                main(null);
                break;
        }
    }

    public void GenerateBill() {
        Billing B = new Billing();
        int b_no = B.getB_no();
        String p_name = B.getP_name();
        int p_id = B.getP_id();
        int b_amt = B.getB_amt();
        System.out.println("BillNO: " + b_no + "\n\tPatientID: " + p_id + "\n\tPatientName: " + p_name + "\n\tBillAmount: " + b_amt + "$\n");
    }

    public void GiveAppoint() {
        Patient P = new Patient();
        String p_name = P.getP_name();
        int p_id = P.getP_id();
        Doctor D = new Doctor();
        int d_id = D.getD_id();
        String d_name = D.getD_name();
        System.out.println("\n PatientID: " + p_id + "\n\tPatientName: " + p_name + "\n\tAppointment with Doctor \n\tDoctorID: " + d_id +
                "\n\tDoctorName" + d_name + "\n");
    }
}

class Patient extends User {

    private int p_id = 333;
    private String p_name = "Mike Jobs";

    public void Choice() {
        System.out.println("Enter your choice:\n1) PayBill\n2) Go back\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                PayBill();
                break;
            default:
                main(null);
                break;
        }
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void PayBill() {
        System.out.println("Thank you for paying your bill.\n");
    }
}

class Doctor extends User {

    private int d_id = 301;
    private String d_name = "Peter Valson";

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public void Choice() {
        System.out.println("Enter your choice:\n1) CheckPatient\n2) Go back\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                CheckPatient();
                break;
            default:
                main(null);
                break;
        }
    }

    public void CheckPatient() {
        Patient P = new Patient();
        String p_name = P.getP_name();
        int p_id = P.getP_id();
        System.out.println("Doctor: " + d_name + " has checked patient " + p_name + ".\n");
    }
}

