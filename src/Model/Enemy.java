package Model;

public class Enemy {

    public int x;
    public int y;

    public int life;

    public String picture;
    public int size;


    public Enemy(int x, int y) {

        this.x = x;
        this.y = y;
        this.picture = "files/Enemy.png";
        this.life = 1;
        this.size = 50;


    }
}


