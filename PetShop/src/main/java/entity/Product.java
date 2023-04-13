/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Product {
    public int proId;
    public String proName;
    public String proCategory;
    public Double proPrice;
    public int proAmount;
    public String proImg;

    public Product() {
    }

    
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProCategory() {
        return proCategory;
    }

    public void setProCategory(String proCategory) {
        this.proCategory = proCategory;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public int getProAmount() {
        return proAmount;
    }

    public void setProAmount(int proAmount) {
        this.proAmount = proAmount;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public Product(int proId, String proName, String proCategory, Double proPrice, int proAmount, String proImg) {
        this.proId = proId;
        this.proName = proName;
        this.proCategory = proCategory;
        this.proPrice = proPrice;
        this.proAmount = proAmount;
        this.proImg = proImg;
    }

    @Override
    public String toString() {
        return "Product{" + "proId=" + proId + ", proName=" + proName + ", proCategory=" + proCategory + ", proPrice=" + proPrice + ", proAmount=" + proAmount + ", proImg=" + proImg + '}';
    }

}
