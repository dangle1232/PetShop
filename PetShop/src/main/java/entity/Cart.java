/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Cart extends Product{
    private int quantity;
    private double total_quantity;

    public double getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(double total_quantity) {
        this.total_quantity = total_quantity;
    }

    

    public Cart() {
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
