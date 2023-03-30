package com.shape;

import java.awt.*;
import java.util.Scanner;

public abstract class Shape {

    public abstract void input();
    public abstract void getArea();

    public abstract void getPerimeter();
}
class Triangle extends Shape{

    private int a;
    private int b;
    private int c;



    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        a = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter b : ");
        b = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter c : ");
        c  = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void getArea() {
        double p = (a + b + c) / 2;
        double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        System.out.printf("Area of triangle is = %.2f %n",area);
    }

    @Override
    public void getPerimeter() {
        double P = a + b + c ;
        System.out.printf("Perimeter of triangle is = %.2f %n",P);
    }
}
class Rectangle extends Shape{
    private int a;
    private int b;


    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        a = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter b : ");
        b = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void getArea() {
        double area = a*b;
        System.out.printf("Radius of the rectangle is = %.2f %n",area);
    }

    @Override
    public void getPerimeter() {
        double P = 2*(a+b);
        System.out.printf("Perimeter of the rectangle is = %.2f %n",P);
    }
}

class Circle extends Shape{
    private int r;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter r : ");
        r = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void getArea() {
        double area = Math.PI*r*r;
        System.out.printf("Radius of the circle is = %.2f %n",area);
    }

    @Override
    public void getPerimeter() {
        double P = Math.PI*2*r;
        System.out.printf("Perimeter of the circle is = %.2f %n",P);
    }
}