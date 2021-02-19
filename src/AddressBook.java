import java.util.*;

public class AddressBook {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<contact> contactArr = new ArrayList<>();
        int optionInput = 0;
        while (optionInput != 3) {
            System.out.println("Welcome to the address book. Please choose an option.");
            System.out.println("(1) Add a contact");
            System.out.println("(2) Search for contact");
            System.out.println("(3) Exit.");
            optionInput = input.nextInt();
            switch (optionInput) {
                case 1:
                    contactArr = addContact();
                    break;
                case 2:
                    searchContact(contactArr);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Enter a valid option!\n");
                    break;
            }
        }
    }


    static List<contact> addContact() {
        Scanner input = new Scanner(System.in);
        List<contact> contactArr = new ArrayList<>();
        System.out.println("Please enter the name of the contact.");
        String contactName = input.nextLine();
        System.out.println("Please enter the email address of the contact.");
        String contactEmail = input.nextLine();
        if (contactEmail.contains("@") && contactEmail.contains(".com")) {
            System.out.println("Contact created!\n");
            contactArr.add(new contact(contactName, contactEmail));
        } else {
            System.out.println("\"" + contactEmail + "\" is not a valid Email!\n");
        }
        return contactArr;
    }

    static void searchContact(List<contact> contactArr) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the contacts name.");
        String contactName = input.nextLine();
        for (contact name : contactArr) {
            if (name.getName().equals(contactName)) {
                System.out.println("Contact found!");
                System.out.println("The email for \"" + contactName + "\" is " + name.getEmailAddress() + "\n");
            } else {
                System.out.println("Contact not found.\n");
            }
        }
    }
}
