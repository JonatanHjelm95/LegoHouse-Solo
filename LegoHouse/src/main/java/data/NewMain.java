/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import logic.LegoLogic;

/**
 *
 * @author jonab
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        printHouse();
        LegoLogic ll = new LegoLogic();
//        ll.createEvenLayer(10, 14);
//        ArrayList<Brick[]> house = ll.getHouse();
//        for (int i = 0; i < house.size(); i++) {
//            Brick[] row = house.get(i);
//            for (int j = 0; j < row.length; j++) {
//                if (row[j] != null) {
//                    System.out.println(row[j].getLength());
//                }
//            }
//            System.out.println("___");
        //4x10 virker for begge
        //6x6 virker for begge
        //5x8 virker for begge
        Stykliste hus = ll.createHouse(4, 6, 6);
        ArrayList<Brick[]> layer1 = (ArrayList<Brick[]>)hus.get("layer 4");
        for (int i = 0; i < layer1.size(); i++) {
            Brick[] row = layer1.get(i);
            for (int j = 0; j < row.length; j++) {
                System.out.println(row[j].getLength());
                System.out.println(row[j].isIsEven());
            }
            System.out.println("___");
        }
        
    }

}
