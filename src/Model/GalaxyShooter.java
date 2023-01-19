package Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;

public class GalaxyShooter extends PApplet {

  private static Player player;
  private Enemy enemy;

    private ArrayList <Enemy> enemies = new ArrayList<>();

    private static ArrayList<Projectile> projectiles = new ArrayList<>();

    int width, height;
    int velocity = 2;


    public GalaxyShooter(int width, int height){

        this.width = width;
        this.height = height;

        player = new Player(width / 2, 630, "files/Player.png");


        enemies.add(new Enemy(500, 500,"files/Enemy.png"));



    }

    public static void movePlayer(int x, int y) {


            player.x = player.x + x;
            player.y = player.y + y;

            if (player.x <= 10) {
                player.x = 715;
            }
            else if (player.x >= 720){
                player.x = 5;
            }



    }

    public void moveEnemy(Enemy enemy){




    }



    public Player getPlayer() {return player;}

    public ArrayList<Enemy> getEnemies(){return enemies;}

    public ArrayList<Projectile> getProjectiles(){return projectiles;}

    public static void playerShoot(){


        projectiles.add(new Projectile(player.x, player.y, "files/Projectile.png"));

    }
    public void moveProjectile(Projectile projectile){

        projectile.move();
    }
    public void deleteProjectile(Projectile projectile){

        projectiles.remove(projectile);
    }

    public void checkDestroy(int projectileX, int projectileY, int enemieX, int enemyY) {

        if (dist(projectileX, projectileY, enemieX, enemyY) <= 10){
            System.out.println("Getroffen");
        }



    }



}

