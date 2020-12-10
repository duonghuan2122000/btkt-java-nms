/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Cart;
import model.Customer;

/**
 *
 * @author Jocelyn
 */
public class ControllerImpl implements Controller {

    @Override
    public <T> void writeFile(String fileName, List<T> l) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(l);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readFile(String fileName) {
        List<T> l = new ArrayList<>();
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            l = (List<T>) ois.readObject();
        } catch (EOFException ex) {

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return l;
    }

    public boolean addOrUpdateCart(List<Cart> carts, Cart cart) {
        Cart cartSelect = carts.stream().filter(c -> c.equals(cart)).findAny().orElse(null);
        if (cartSelect == null) {
            if (carts.size() > 10) {
                return false;
            }
            carts.add(cart);
        } else {
            cartSelect.setQuantity(cartSelect.getQuantity() + cart.getQuantity());
        }
        return true;
    }

    @Override
    public void sortByCustomerName(List<Cart> carts) {
        carts.sort((c1, c2) -> {
            String fullName1 = c1.getCustomer().getFullName().trim();
            String fullName2 = c2.getCustomer().getFullName().trim();
            String name1 = fullName1.substring(fullName1.lastIndexOf(" "));
            String name2 = fullName2.substring(fullName2.lastIndexOf(" "));
//            return name2.compareTo(name1);
            return name1.compareTo(name2);
        });
    }

    @Override
    public void sortByProductName(List<Cart> carts) {
        carts.sort((c1, c2) -> {
            String name1 = c1.getProduct().getName();
            String name2 = c2.getProduct().getName();
            return name1.compareTo(name2);
        });
    }

    @Override
    public List<Cart> getCartsByCustomer(List<Cart> carts, Customer customer) {
        return carts.stream().filter(c -> c.getCustomer().getId() == customer.getId()).collect(Collectors.toList());
    }

}
