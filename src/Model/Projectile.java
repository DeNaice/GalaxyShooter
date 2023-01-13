package Model;

public class Projectile {

    public int x;

    public int y;

    public int size;

    public int speed = 1;

    public Projectile(int x, int y, int size, int speed){

        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }

}
