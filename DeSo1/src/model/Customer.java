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
public class Customer implements Serializable {

    private int id;
    private String fullName, add, phone;
    private static int sId = 10000;

    public Customer() {
        id = sId++;
    }

    public Customer(String fullName, String add, String phone) {
        this.id = sId++;
        this.fullName = fullName;
        this.add = add;
        this.phone = phone;
    }

    public Object[] toObject() {
        return new Object[]{
            id, fullName, add, phone
        };
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAdd() {
        return add;
    }

    public String getPhone() {
        return phone;
    }
    

    public static void setsId(int sId) {
        Customer.sId = sId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    

}
