package ca.dongguo.pizza;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable, Comparable<Person> {

    private String name;
    private String email;
    private int phoneNumber;
    private Pizza pizza;

    public Person() {
    }

    public Person(String name, String email, int phoneNumber, Pizza pizza) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pizza = pizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return name +
                ", " + email +
                ", " + phoneNumber +
                ", " + pizza +
                '\n';
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(pizza, person.pizza);
    }


    @Override
    public int hashCode() {
        return Objects.hash(pizza);
    }
}
