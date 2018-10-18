/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Jonatan
 */
public class Order {

    private int OrderID, height, lenX, lenY, noBricks, TotalPrice;
    private String status;
    private Timestamp created;

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLenX(int lenX) {
        this.lenX = lenX;
    }

    public void setLenY(int lenY) {
        this.lenY = lenY;
    }

    public void setNoBricks(int noBricks) {
        this.noBricks = noBricks;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order(int height, int lenX, int lenY) {
        this.height = height;
        this.lenX = lenX;
        this.lenY = lenY;
    }
    private Date date;

    public Order(int height, int lenX, int lenY, int noBricks, int TotalPrice, String status) {
        this.height = height;
        this.lenX = lenX;
        this.lenY = lenY;
        this.noBricks = noBricks;
        this.TotalPrice = TotalPrice;
        this.status = status;
        this.created = new Timestamp(date.getTime());
    }

    public Order() {
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getOrderID() {
        return OrderID;
    }

    public int getHeight() {
        return height;
    }

    public int getLenX() {
        return lenX;
    }

    public int getLenY() {
        return lenY;
    }

    public int getNoBricks() {
        return noBricks;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getCreated() {
//        created = new java.sql.Timestamp(date.getTime());
        return created;
    }

}
