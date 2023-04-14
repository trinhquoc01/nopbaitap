package CompanyManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyManagement {
    public static void main(String[] args) {
        CompanyManagement.MainMenu();
    }
    private static List<Person> list = new ArrayList<Person>();
    private static Person person;
    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add New Person");
            System.out.println("2. Show all people");
            System.out.println("3. Search people by id");
            System.out.println("4. Update person information");
            System.out.println("5. See the person's salary");
            System.out.println("6. Update salary for people");
            System.out.print("Enter your selection (1 - 6): ");
            String selectedMenu = scanner.nextLine();
            switch (selectedMenu) {
                case "1" -> {
                    addnewperson();
                }
                case "2" -> {
                    displayall();
                }
                case "3" -> {
                    findPersonById();
                }
                case "4" -> {
                    updatePerson();
                }
                case "5" -> {
                    checkSalary();
                }
                case "6" -> {
                    updateSalary();
                }
                case "7" -> {
                    getTotalBonusOfCompany();
                }
            }
        }

    }
    private static Person findPerson(int id) {
        for (Person person : list) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
    private static void addnewperson() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Director");
            System.out.println("2. Manager");
            System.out.println("3. Employee");
            System.out.println("Enter Q to return");
            String selectedMenu = scanner.nextLine();

            switch (selectedMenu) {
                case "1" -> {
                    person = new Director();
                }
                case "2" -> {
                    person = new Manager();
                }
                case "3" -> {
                    person = new Employee();
                }
                case "Q" -> {
                    return;
                }
            }
            person.input();
            list.add(person);
        }
    }
    private static void displayall() {
        System.out.println("Show total number of people");
        for (Person person : list) {
            person.display();
        }
    }
    private static void findPersonById() {
         Scanner scanner = new Scanner(System.in);
         while (true) {
            System.out.println();
            int id;
            System.out.print("Enter the ID of the person you want to search : ");
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break ;
            }
            Person result = findPerson(id);
            if (result != null) {
                System.out.print("Results found : ");
                result.display();
            } else {
                System.out.println("Can't find anyone");
            }
        }
    }

    private static void updatePerson() {
        Scanner scanner = new Scanner(System.in);
        findPersonLoop: while (true) {
            System.out.println();
            int id;
            System.out.print("Enter the ID of the person you want to update(Enter Q to return) : ");
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break findPersonLoop;
            }
            Person result = findPerson(id);
            if (result != null) {
                System.out.print("Results found: ");
                result.updatePerson();
            } else {
                System.out.println("Can't find anyone ");
            }
        }
    }

    private static void checkSalary() {
        Scanner scanner = new Scanner(System.in);
        findPersonLoop: while (true) {
            System.out.println();
            int id;
            System.out.print("Enter the ID of the person you want to see the amount of (Enter Q to return): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break findPersonLoop;
            }
            Person result = findPerson(id);
            if (result != null) {
                System.out.print("Results found: ");
                result.display();
            } else {
                System.out.println("Can't find anyone");
            }
        }
    }

    private static void updateSalary() {
        Scanner scanner = new Scanner(System.in);
        findPersonLoop: while (true) {
            System.out.println();
            int id;
            System.out.print("Enter the ID of the person you want to update (Enter Q to return): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break findPersonLoop;
            }
            Person result = findPerson(id);
            if (result != null) {
                System.out.print("Results found: ");
                result.display();
                result.updateSalary();
            } else {
                System.out.println("Can't find anyone");
            }
        }
    }
    private static void getTotalBonusOfCompany() {
        Scanner scanner = new Scanner(System.in);

    }
}
