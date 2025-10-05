package org.example.models;

public class People implements IModel {
    private String firstName;
    private String lastName;
    private int age;
    private String citizenship;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public People(String firstName, String lastName, int age, String citizenship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.citizenship = citizenship;
    }
}
