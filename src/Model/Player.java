package Model;

import processing.core.PImage;

public class Player {

    public int life;
    public int x;
    public int y;

    PImage playerSprite;


    public Player(int x, int y, PImage playerSprite){

        this.x = x;
        this.y = y;
        this.life = 3;
        this.playerSprite = playerSprite;


    }

    void move(int x, int y) {
        this.x = x;
        this.y = y;

    }

}
