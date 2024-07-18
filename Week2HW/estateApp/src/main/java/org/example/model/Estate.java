package org.example.model;

public class Estate {
    private String name;
    private int m2;
    private int numOfRoom;
    private int numOfHall;
    private int price;

    public Estate(String name, int m2, int numOfRoom, int numOfHall, int price) {
        this.name = name;
        this.m2 = m2;
        this.numOfRoom = numOfRoom;
        this.numOfHall = numOfHall;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public int getNumOfHall() {
        return numOfHall;
    }

    public void setNumOfHall(int numOfHall) {
        this.numOfHall = numOfHall;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
