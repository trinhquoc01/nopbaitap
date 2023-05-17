package AZBank.model;

import java.util.Scanner;

public class Customer {
    int id;
    String name;
    String city;
    String country;
    String phone;
    String email;

    public void inputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter City : ");
        this.city = scanner.nextLine();
        System.out.print("Enter Country : ");
        this.country = scanner.nextLine();
        System.out.print("Enter Phone : ");
        this.phone = scanner.nextLine();
        System.out.print("Enter Email :");
        this.email = scanner.nextLine();
    }

    public Customer(int id, String name, String city, String country, String phone, String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public Customer() {

    }
}
