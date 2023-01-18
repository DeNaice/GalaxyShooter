package Model;

import java.util.ArrayList;

public class GalaxyShooter {

  private Player player;
  private Enemy enemy;

    private ArrayList <Enemy> enemies = new ArrayList<>();

    private ArrayList<Projectile> projectiles = new ArrayList<>();

    int width, height;
    int velocity = 2;


    public GalaxyShooter(int width, int height){

        this.width = width;
        this.height = height;

        player = new Player(width / 2, 630, "files/Player.png");


        enemies.add(new Enemy(500, 500,1,"files/Enemy.png"));

    }

    public void movePlayer(int x, int y) {


            player.x = player.x + x;
            player.y = player.y + y;



    }

    public void moveEnemy(Enemy enemy){



    }



    public Player getPlayer() {return player;}

    public ArrayList<Enemy> getEnemies(){return enemies;}

    public void playerShoot(){

        int x = player.x;
        int y = player.y;

       // TODO ArrayList projectiles = new Projectile()

    }

}
