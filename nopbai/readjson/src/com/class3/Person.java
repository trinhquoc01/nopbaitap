package com.class3;

import java.util.List;

class Phone {
    String type;
    String number;
}

public class Person {
    String firstName;
    String lastName;
    int age;
    Address address;
    List<Phone> listNumbers;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
