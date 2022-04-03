package com.company;

public class Product {

    public String title;
    public int price;
    public int indexNumber;
    public int qty;

    public Product(String title, int price, int indexNumber) {
        this.title = title;
        this.price = price;
        this.indexNumber = indexNumber;
    }

    public String toString() {
        return indexNumber + ". " + title + " " + price + " руб/шт";
    }
}
