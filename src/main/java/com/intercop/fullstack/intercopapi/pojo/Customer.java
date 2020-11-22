package com.intercop.fullstack.intercopapi.pojo;

public class Customer {

    private String name;

    private String surname;

    private int age;

    private String birthDate;

    private String probableDeathDate;

    public Customer() {
        
    }

    public Customer(String name, String surname, int age, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getProbableDeathDate() {
        return probableDeathDate;
    }

    public void setProbableDeathDate(String probableDeathDate) {
        this.probableDeathDate = probableDeathDate;
    }

    // Creating toString
    @Override
    public String toString()
    {
        return "Customer [name="
                + this.name
                + ", surname="
                + this.surname
                + ", age="
                + this.age + "]";
    }
}