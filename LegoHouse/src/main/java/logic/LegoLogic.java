/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jonatan
 */
public class LegoLogic {

    public Stykliste createHouse(int height, int lenX, int lenY) throws ArrayIndexOutOfBoundsException {
        Stykliste hus = new Stykliste();
        for (int i = 0; i < height; i++) {
            String layerName = "layer " + (i + 1);
            if (i % 2 == 0) {
                hus.put(layerName, createEvenLayer(lenX, lenY));
            }
            if (i % 2 != 0) {
                hus.put(layerName, createUnevenLayer(lenX, lenY));
            }
        }
        return hus;
    }

    public ArrayList<Brick[]> createEvenLayer(int lenX, int lenY) throws ArrayIndexOutOfBoundsException {
        ArrayList<Brick[]> house = new ArrayList<Brick[]>();
        //side1-----------------------------------------
        int brickCount = 0;
        int rowLength = 0;
        int availableRoom = lenX * 2;
        Brick[] side1 = new Brick[availableRoom];
        for (int i = 0; rowLength < availableRoom - 2; i++) {
            if (i == 0) {
                side1[i] = new Brick(2, true);
                rowLength += side1[i].getLength();
                brickCount++;
            }
            if (i > 0 && side1[i - 1].getLength() == 2) {
                side1[i] = new Brick(4, true);
                rowLength += side1[i].getLength();
                brickCount++;

            }
            if (i > 0 && side1[i - 1].getLength() == 4) {
                side1[i] = new Brick(2, true);
                rowLength += side1[i].getLength();
                brickCount++;

            }
        }
        Brick[] side1Trim = new Brick[brickCount];
        for (int i = 0; i < side1.length; i++) {
            if (side1[i] != null) {
                side1Trim[i] = side1[i];
            }
        }
        house.add(side1Trim);
        //side2-----------------------------------------
        int x = side1Trim.length - 1;
        if (availableRoom - rowLength == 0) {
            availableRoom = lenY * 2 - 2;
        } else {
            availableRoom = lenY * 2;
        }
        brickCount = 0;
        rowLength = 0;
        Brick[] side2 = new Brick[availableRoom];
        for (int i = 0; rowLength < availableRoom - 2; i++) {
            if (i == 0 && side1Trim[x].getLength() == 4) {
                side2[i] = new Brick(2, true);
                rowLength += side2[i].getLength();
                brickCount++;
            }
            if (i == 0 && side1Trim[x].getLength() == 2) {
                side2[i] = new Brick(4, true);
                rowLength += side2[i].getLength();
                brickCount++;
            }
            if (i > 0 && side2[i - 1].getLength() == 4) {
                side2[i] = new Brick(2, true);
                rowLength += side2[i].getLength();
                brickCount++;
            }
            if (i > 0 && side2[i - 1].getLength() == 2) {
                side2[i] = new Brick(4, true);
                rowLength += side2[i].getLength();
                brickCount++;
            }
            if (availableRoom == 4 && side2[i - 1].getLength() == 2) {
                side2[i] = new Brick(4, true);
                rowLength += side2[i].getLength();
                brickCount++;
            }
        }
        Brick[] side2Trim = new Brick[brickCount];
        for (int i = 0; i < side2.length; i++) {
            if (side2[i] != null) {
                side2Trim[i] = side2[i];
            }
        }
        house.add(side2Trim);
        //side3
        int z = side2Trim.length - 1;
        if (availableRoom - rowLength == 0) {
            availableRoom = lenX * 2 - 2;
        } else {
            availableRoom = lenX * 2;
        }
        rowLength = 0;
        brickCount = 0;
        Brick[] side3 = new Brick[availableRoom];
        for (int i = 0; rowLength < availableRoom - 2; i++) {

            if (i == 0 && side2Trim[z].getLength() == 4) {
                side3[i] = new Brick(2, true);
                rowLength += side3[i].getLength();
                brickCount++;
            }
            if (i == 0 && side2Trim[z].getLength() == 2) {
                side3[i] = new Brick(4, true);
                rowLength += side3[i].getLength();
                brickCount++;
            }
            if (i > 0 && side3[i - 1].getLength() == 4) {
                side3[i] = new Brick(2, true);
                rowLength += side3[i].getLength();
                brickCount++;
            }
            if (i > 0 && side3[i - 1].getLength() == 2) {
                side3[i] = new Brick(4, true);
                rowLength += side3[i].getLength();
                brickCount++;
            }
//            System.out.println("wall 3 length: " + rowLength);

        }
        Brick[] side3Trim = new Brick[brickCount];
        for (int i = 0; i < side3.length; i++) {
            if (side3[i] != null) {
                side3Trim[i] = side3[i];
            }
        }
        house.add(side3Trim);
        //side4-----------------------------------------
        int y = side3Trim.length - 1;
        if (availableRoom - rowLength == 0) {
            availableRoom = (lenY * 2) - 4;
        } else {
            availableRoom = (lenY * 2) - 2;
        }
        rowLength = 0;
        brickCount = 0;
        Brick[] side4 = new Brick[availableRoom];
        for (int i = 0; rowLength < availableRoom; i++) {
            if (i == 0 && side3Trim[y].getLength() == 4) {
                side4[i] = new Brick(2, true);
                rowLength += side4[i].getLength();
                brickCount++;
            }
            if (i == 0 && side3Trim[y].getLength() == 2) {
                side4[i] = new Brick(4, true);
                rowLength += side4[i].getLength();
                brickCount++;

            }

            if (i > 0 && availableRoom - rowLength == 4) { //finalizing
                side4[i] = new Brick(4, true);
                rowLength += side4[i].getLength();
                brickCount++;
                availableRoom = 0;
                break;
            }
            if (i > 0 && side4[i - 1].getLength() == 4) {
                side4[i] = new Brick(2, true);
                rowLength += side4[i].getLength();
                brickCount++;

            }
            if (i > 0 && side4[i - 1].getLength() == 2) {
                side4[i] = new Brick(4, true);
                rowLength += side4[i].getLength();
                brickCount++;

            }
        }
        Brick[] side4Trim = new Brick[brickCount];
        for (int i = 0; i < side4.length; i++) {
            if (side4[i] != null) {
                side4Trim[i] = side4[i];
            }
        }

        house.add(side4Trim);
        return house;
    }

    public ArrayList<Brick[]> createUnevenLayer(int lenX, int lenY) throws ArrayIndexOutOfBoundsException {
        ArrayList<Brick[]> house = new ArrayList<Brick[]>();

        //side1-----------------------------------------
        int brickCount = 0;
        int rowLength = 0;
        int availableRoom = lenX * 2 - 2;
        Brick[] side1 = new Brick[availableRoom];
        for (int i = 0; rowLength < availableRoom - 2; i++) {
            if (i == 0) {
                side1[i] = new Brick(2, false);
                rowLength += side1[i].getLength();
                brickCount++;
            }
            if (i > 0 && side1[i - 1].getLength() == 2) {
                side1[i] = new Brick(4, false);
                rowLength += side1[i].getLength();
                brickCount++;

            }
            if (i > 0 && side1[i - 1].getLength() == 4) {
                side1[i] = new Brick(2, false);
                rowLength += side1[i].getLength();
                brickCount++;

            }
        }
        Brick[] side1Trim = new Brick[brickCount];
        for (int i = 0; i < side1.length; i++) {
            if (side1[i] != null) {
                side1Trim[i] = side1[i];
            }
        }
        house.add(side1Trim);
        //side2-----------------------------------------
        int x = side1Trim.length - 1;
        if (availableRoom - rowLength == 0) {
            availableRoom = lenY * 2 - 2;
        } else {
            availableRoom = lenY * 2;
        }
        brickCount = 0;
        rowLength = 0;
        Brick[] side2 = new Brick[availableRoom];
        for (int i = 0; rowLength < availableRoom - 2; i++) {
            if (i == 0 && side1Trim[x].getLength() == 4) {
                side2[i] = new Brick(2, false);
                rowLength += side2[i].getLength();
                brickCount++;
            }
            if (i == 0 && side1Trim[x].getLength() == 2) {
                side2[i] = new Brick(4, false);
                rowLength += side2[i].getLength();
                brickCount++;
            }
            if (i > 0 && side2[i - 1].getLength() == 4) {
                side2[i] = new Brick(2, false);
                rowLength += side2[i].getLength();
                brickCount++;
            }
            if (i > 0 && side2[i - 1].getLength() == 2) {
                side2[i] = new Brick(4, false);
                rowLength += side2[i].getLength();
                brickCount++;
            }
            if (availableRoom == 4 && side2[i - 1].getLength() == 2) {
                side2[i] = new Brick(4, false);
                rowLength += side2[i].getLength();
                brickCount++;
            }
        }
        Brick[] side2Trim = new Brick[brickCount];
        for (int i = 0; i < side2.length; i++) {
            if (side2[i] != null) {
                side2Trim[i] = side2[i];
            }
        }
        house.add(side2Trim);
        //side3-----------------------------------------
        int z = side2Trim.length - 1;
        if (availableRoom - rowLength == 0) {
            availableRoom = lenX * 2 - 2;
        } else {
            availableRoom = lenX * 2;
        }
        rowLength = 0;
        brickCount = 0;
        Brick[] side3 = new Brick[availableRoom];
        for (int i = 0; rowLength < availableRoom - 2; i++) {

            if (i == 0 && side2Trim[z].getLength() == 4) {
                side3[i] = new Brick(2, false);
                rowLength += side3[i].getLength();
                brickCount++;
            }
            if (i == 0 && side2Trim[z].getLength() == 2) {
                side3[i] = new Brick(4, false);
                rowLength += side3[i].getLength();
                brickCount++;
            }
            if (i > 0 && side3[i - 1].getLength() == 4) {
                side3[i] = new Brick(2, false);
                rowLength += side3[i].getLength();
                brickCount++;
            }
            if (i > 0 && side3[i - 1].getLength() == 2) {
                side3[i] = new Brick(4, false);
                rowLength += side3[i].getLength();
                brickCount++;
            }

        }
        Brick[] side3Trim = new Brick[brickCount];
        for (int i = 0; i < side3.length; i++) {
            if (side3[i] != null) {
                side3Trim[i] = side3[i];
            }
        }
        house.add(side3Trim);
        //side4-----------------------------------------
        int y = side3Trim.length - 1;
        if (availableRoom - rowLength == 0) {
            availableRoom = (lenY * 2) - 2;
        } else {
            availableRoom = (lenY * 2);
        }
        rowLength = 0;
        brickCount = 0;
        Brick[] side4 = new Brick[availableRoom];
        for (int i = 0; rowLength < availableRoom; i++) {
            if (i == 0 && side3Trim[y].getLength() == 4) {
                side4[i] = new Brick(2, false);
                rowLength += side4[i].getLength();
                brickCount++;
            }
            if (i == 0 && side3Trim[y].getLength() == 2) {
                side4[i] = new Brick(4, false);
                rowLength += side4[i].getLength();
                brickCount++;

            }

            if (i > 0 && availableRoom - rowLength == 4) { //finalizing
                side4[i] = new Brick(4, false);
                rowLength += side4[i].getLength();
                brickCount++;
                availableRoom = 0;
                break;
            }
            if (i > 0 && availableRoom - rowLength == 2) { //finalizing
                side4[i] = new Brick(2, false);
                rowLength += side4[i].getLength();
                brickCount++;
                availableRoom = 0;
                break;
            }
            if (i > 0 && side4[i - 1].getLength() == 4) {
                side4[i] = new Brick(2, false);
                rowLength += side4[i].getLength();
                brickCount++;

            }
            if (i > 0 && side4[i - 1].getLength() == 2) {
                side4[i] = new Brick(4, false);
                rowLength += side4[i].getLength();
                brickCount++;

            }

        }
        Brick[] side4Trim = new Brick[brickCount];
        for (int i = 0; i < side4.length; i++) {
            if (side4[i] != null) {
                side4Trim[i] = side4[i];
            }
        }

        house.add(side4Trim);
        return house;
    }
    
    public int getHousePrice(Stykliste dav){
        return 0;
    }
}

