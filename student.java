import java.util.Scanner;

public class student {
    String name;
    String email;
    int age;

    public Student() {
    }

    public void input() {
        Scanner Input = new Scanner(System.in);

        do {
            System.out.println("Enter age");
            this.age = Input.nextInt();
            Input.nextLine();
        } while (this.age == this.age);

        System.out.println("Enter name");
        this.name = Input.nextLine();
        System.out.print("Enter email: ");
        this.name = Input.nextLine();
    }
    public void display() {
        System.out.println("age is: " + this.age);
        System.out.println("name is: "+ this.name);
        System.out.println("email is: "+ this.email);
    }
}
