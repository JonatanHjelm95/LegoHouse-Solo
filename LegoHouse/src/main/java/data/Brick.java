/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Jonatan
 */
public class Brick {
    private int length;
    private final int width = 2;
    private int price;
    private boolean isEven;

    public boolean isIsEven() {
        return isEven;
    }

    public void setIsEven(boolean isEven) {
        this.isEven = isEven;
    }

    public Brick(int length, boolean isEven) {
        this.length = length;
        this.isEven = isEven;
    }

    

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrice() {
        price = length*width;
        return price;
    }



}
