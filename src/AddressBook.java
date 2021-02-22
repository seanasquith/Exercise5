import java.util.*;

public class AddressBook {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Contact> contactArr = new ArrayList<>(); //Arraylist that stores Contact objects
        int optionInput = 0;
        while (optionInput != 4) { //Exits loop when user enters 4
            System.out.println("Welcome to the address book! Please choose an option.");
            System.out.println("(1) Add a contact");
            System.out.println("(2) Search for contact");
            System.out.println("(3) List all contacts");
            System.out.println("(4) Exit");
            try {
                optionInput = input.nextInt();
            } catch (Exception e) { // Prevents the user from entering a string into input.nextInt()
                input.next(); //Discards invalid input (Infinite loop otherwise)
            }
            switch (optionInput) {
                case 1:
                    addContact(contactArr);
                    System.out.println(); //Adds a line break after each method
                    break;
                case 2:
                    searchContact(contactArr);
                    System.out.println();
                    break;
                case 3:
                    listContacts(contactArr);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting address book...");
                    break;
                default:
                    System.out.println("Enter a valid option!\n"); //If the user doesn't input 1,2,or 3
                    break;
            }
        }
    }


    static void addContact(List<Contact> contactArr) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the contact.");
        String contactName = input.nextLine();
        System.out.println("Please enter the email address of the contact.");
        String contactEmail = input.nextLine();

        if (contactEmail.contains("@") && contactEmail.contains(".")) { //Checks to see if user entered valid email
            System.out.println("Contact created!");
            contactArr.add(new Contact(contactName, contactEmail));
        } else {
            System.out.println("\"" + contactEmail + "\" is not a valid Email!");
        }
    }

    static void searchContact(List<Contact> contactArr) {
        Scanner input = new Scanner(System.in);
        String nameMatch = "";
        String emailMatch = "";
        if (!contactArr.isEmpty()) {
            System.out.println("Please enter the contacts name.");
            String contactName = input.nextLine();
            for (Contact name : contactArr) { //Loops through each contact in the arraylist and if it matches the user input,
                if (name.getName().equals(contactName)) { // Then the name and email are stored and printed afterwards
                    nameMatch = name.getName();
                    emailMatch = name.getEmailAddress();
                }
            }
            if (!nameMatch.isEmpty() && !emailMatch.isEmpty()) { //If there is a match
                System.out.println("Contact found!");
                System.out.println("The email for \"" + nameMatch + "\" is " + emailMatch);
            } else {
                System.out.println("Contact not found!");
            }
        } else {
            System.out.println("The address book is empty!"); //If contact arraylist is empty
        }
    }

    static void listContacts(List<Contact> contactArr) {
        if (!contactArr.isEmpty()) {
            System.out.println("Address book:");
            for (int i = 0; i < contactArr.size(); i++) { //Loops through each contact in the arraylist
                Contact name = contactArr.get(i);
                System.out.println((i + 1) + ". " + name.getName() + " " + name.getEmailAddress());
            }
        } else {
            System.out.println("The address book is empty!");
        }
    }
}