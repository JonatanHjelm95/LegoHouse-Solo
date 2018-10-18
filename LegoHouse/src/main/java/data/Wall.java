/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Jonatan
 */
public class Wall extends ArrayList {
    ArrayList<Brick[]> bricks;

    public Wall(ArrayList<Brick[]> bricks) {
        this.bricks = bricks;
    }

    public ArrayList<Brick[]> getBricks() {
        return bricks;
    }

    public void setBricks(ArrayList<Brick[]> bricks) {
        this.bricks = bricks;
    }


}
