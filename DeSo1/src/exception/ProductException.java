/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Jocelyn
 */
public class ProductException extends Exception {

    public ProductException() {
    }
    
    public ProductException(String message) {
        super(message);
    }
}
