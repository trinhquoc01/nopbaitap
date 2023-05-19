package AddressBooks;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        AddressBook addressBook = new AddressBook();

        while (!isExit) {
            System.out.println();
            System.out.println("=".repeat(10) + " Welcome to Address Book program " + "=".repeat(10));
            System.out.println("""
                    1. Add new contact
                    2. Find a contact by name
                    3. Display contacts
                    5. Exit""");
            System.out.print("Enter your selection: ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1" -> {
                    System.out.println();
                    System.out.println("-".repeat(10) + " Add new contact " + "-".repeat(10));
                    try {
                        addressBook.addContact();
                        System.out.println("Add new contact successfully");
                    } catch (Exception e) {
                        System.out.println("Add new contact failed");
                    }
                }
                case "2" -> {
                    System.out.println();
                    System.out.println("-".repeat(10) + " Find a contact by name " + "-".repeat(10));
                    addressBook.findContact();
                }
                case "3" -> {
                    System.out.println();
                    System.out.println("-".repeat(10) + " Display contacts " + "-".repeat(10));
                    addressBook.displayContacts();
                }
                case "4" -> {
                    isExit = true;
                }
            }
        }
    }


}
