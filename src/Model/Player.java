package Model;

import processing.core.PImage;

public class Player {


    public int life;
    public int x;
    public int y;

    public String picture;

    public int size;


    public Player(int x, int y, String picture) {

        this.x = x;
        this.y = y;
        this.life = 3;
        this.picture = picture;
        this.size = 100;


    }



    public void getDamage() {

        this.life = life - 1;
    }
}
