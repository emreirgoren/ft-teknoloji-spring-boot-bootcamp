package model;


import java.time.LocalDateTime;
import java.util.List;

public class Customer {

    private String name;

    private String lastName;

    private int age;

    //private List<Order> orderList;



    public Customer(String name, String lastName, int age){
        this.name=name;
        this.lastName=lastName;
        this.age = age;
    }



    // Getter And Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +

                '}';
    }
}
