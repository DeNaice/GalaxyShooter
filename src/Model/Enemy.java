package Model;

public class Enemy {

    public int x;
    public int y;

    public int life;

    public String picture;
    public int size;



    public Enemy(int x, int y,int life, String picture){

        this.x = x;
        this.y = y;
        this.picture = picture;
        this.life = life;
        this.size = 50;



    }

    void move(){

        this.x = x;
        this.y = y;

    }

    public boolean isAlive(){
        return life > 0;
    }




}
