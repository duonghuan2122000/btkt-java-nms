/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Jocelyn
 */
public class Product implements Serializable {

    private int id;
    private String name, type;
    private double price;
    private static int sId = 1000;

    public Product() {
        id = sId++;
    }

    public Product(String name, String type, double price) {
        this.id = sId++;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Object[] toObject() {
        return new Object[]{
            id, name, type, price
        };
    }

    public static void setsId(int sId) {
        Product.sId = sId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public static int getsId() {
        return sId;
    }
    
    

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}
