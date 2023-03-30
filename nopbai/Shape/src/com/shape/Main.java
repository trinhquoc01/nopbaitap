package com.shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the sides of the triangle");
        Triangle triangle = new Triangle();
        triangle.input();
        triangle.getArea();
        triangle.getPerimeter();

        System.out.println("Enter the sides of the rectangle");
        Rectangle rectangle = new Rectangle();
        rectangle.input();
        rectangle.getArea();
        rectangle.getPerimeter();

        System.out.println("Enter the edges of the circle");
        Circle circle = new Circle();
        circle.input();
        circle.getArea();
        circle.getPerimeter();
    }
}
