import java.util.*;

class Register {
    String firstName;
    String lastName;
    String userName;
    String password;
    String emailId;
    long phoneNo;

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getemailId() {
        return emailId;
    }

    public void setemailId(String emailId) {
        this.emailId = emailId;
    }

    public long getphoneNo() {
        return phoneNo;
    }

    public void setphoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
}

class bankdetails {
    String accno;
    String name;
    long balance;
    Scanner sc = new Scanner(System.in);

    public void openaccount() {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    public void showaccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Balance: " + balance);
    }

    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
        showaccount();
    }

    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt);
        }
        showaccount();
    }
}

public class bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Register register = new Register();

        System.out.println("Enter First Name:");
        register.setfirstName(sc.nextLine());

        System.out.println("Enter Last Name:");
        register.setlastName(sc.nextLine());

        System.out.println("Enter Username:");
        register.setuserName(sc.nextLine());

        System.out.println("Enter Password:");
        register.setpassword(sc.nextLine());

        System.out.println("Enter Email Id:");
        register.setemailId(sc.nextLine());

        System.out.println("Enter Phone Number:");
        register.setphoneNo(Long.parseLong(sc.nextLine()));
        boolean loginSuccessful = false;
        while (!loginSuccessful) {
            System.out.println("Enter Username:");
            String usernameInput = sc.nextLine();

            System.out.println("Enter Password:");
            String passwordInput = sc.nextLine();
            if (usernameInput.equals(register.getuserName()) && passwordInput.equals(register.getpassword())) {
                loginSuccessful = true;
                System.out.println("Login Successful!");
                System.out.println("\n                Bank of Boroda mein aap ka swagat hai\n");
                System.out.println(
                        "1. opening an account \n2. Deposit the amount \n3. Withdraw the amount \n4.Exit ");
                System.out.println("Enter your choice: ");
                bankdetails b = new bankdetails();
                boolean found = false;
                while (true) {
                    int numberofsteps = sc.nextInt();
                    switch (numberofsteps) {
                        case 1:
                            b.openaccount();
                            found = true;
                            System.out.println("\n");
                            break;
                        case 2:
                            if (found) {
                                b.deposit();
                            } else {
                                System.out.println("Account doesn't exist..!!");
                            }
                            System.out.println("\n");
                            break;
                        case 3:
                            if (found) {
                                b.withdrawal();
                            } else {
                                System.out.println("Account doesn't exist..!!");
                            }
                            System.out.println("\n");
                            break;
                        case 4:
                            System.out.println("See you soon...");
                            System.out.println("\n");
                            break;
                    }
                }
            }
        }
    }
}
