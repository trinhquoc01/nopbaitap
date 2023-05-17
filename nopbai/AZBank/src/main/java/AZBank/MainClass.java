package AZBank;

import AZBank.model.Customer;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        CustomerManagement management = new CustomerManagement();

        int choose = 0;
        Scanner input = new Scanner(System.in);

        try {
            do {

                System.out.println("1. Add new Customer");
                System.out.println("2. View all Customer");
                System.out.println("3. Get Customer by ID");
                System.out.println("4. Update Customer by ID");
                System.out.println("5. Delete Customer by ID");
                System.out.println("6. Exit");

                choose = input.nextInt();

                switch (choose) {
                    case 1: {
                        Customer cus = new Customer();
                        cus.inputData();
                        management.addnewCustomer(cus);
                    }

                    case 2: {
                        management.getAllCustomer();
                    }
                    break;

                    case 3:{
                        System.out.print("Enter Id :");
                        int id = input.nextInt();

                        Customer cus = management.getCustomerByIdStored(id);
                        if (cus != null) {
                            System.out.println(cus.toString());
                        }
                        else {
                            System.out.println("Not found");
                        }
                    }
                    break;

                    case 4: {
                        System.out.print("Enter Customer id to update: ");
                        int id = input.nextInt();

                        management.updateCustomer(id);
                    }
                    break;

                    case 5: {
                        System.out.print("Enter Customer id to delete: ");
                        int id = input.nextInt();
                        management.deleteCustomer(id);
                    }
                    break;

                    case 6: {
                        return;
                    }

                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
