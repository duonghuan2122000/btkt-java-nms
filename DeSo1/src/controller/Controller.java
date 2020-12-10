/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Cart;
import model.Customer;

/**
 *
 * @author Jocelyn
 */
public interface Controller {
    <T> void writeFile(String fileName, List<T> l);
    
    <T> List<T> readFile(String fileName);
    
    void sortByCustomerName(List<Cart> carts);
    
    void sortByProductName(List<Cart> carts);
    
    List<Cart> getCartsByCustomer(List<Cart> carts, Customer customer);
}
