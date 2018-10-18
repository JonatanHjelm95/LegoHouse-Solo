/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jonatan
 */
public class Stykliste extends HashMap {

    private HashMap<String, ArrayList<Brick[]>> house;
    private int numberOfBricks;
    private int totalPrice;

    public int getNumberOfBricks() {
        for (int i = 0; i < house.size(); i++) {
            String layer_str = "layer " + i + 1;
            ArrayList<Brick[]> layer = house.get(layer_str);
            for (int j = 0; j < layer.size(); j++) {
                Brick[] row = layer.get(i);
                numberOfBricks += row.length;
            }
        }
        return numberOfBricks;
    }

    public int getTotalPrice() {

        for (int i = 0; i < house.size(); i++) {
            String layer_str = "layer " + i + 1;
            ArrayList<Brick[]> layer = house.get(layer_str);
            for (int j = 0; j < layer.size(); j++) {
                Brick[] row = layer.get(i);
                for (Brick brick : row) {
                    totalPrice += brick.getPrice();
                }
            }
        }
        return totalPrice;
    }

}
