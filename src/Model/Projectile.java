package Model;

public class Projectile {

    public int x;
    public int y;

    public String picture;

    public int size;

    public int speed = 1;

    public Projectile(int x, int y, String picture){

        this.x = x;
        this.y = y;
        this.picture = picture;
        this.size = 20;

    }

    void move(){
        this.x = x;
        this.y = y-2;
    }

}
