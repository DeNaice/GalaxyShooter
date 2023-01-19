package Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;

public class GalaxyShooter extends PApplet {

    private static Player player;
    private Enemy enemy;

    private ArrayList<Enemy> enemies = new ArrayList<>();

    private static ArrayList<Projectile> projectiles = new ArrayList<>();

    int width, height;
    int velocity = 2;


    public GalaxyShooter(int width, int height) {

        this.width = width;
        this.height = height;

        player = new Player(width / 2, 630, "files/Player.png");


        enemies.add(new Enemy(100, 100, "files/Enemy.png"));


    }

    public static void movePlayer(int x, int y) {


        player.x = player.x + x;
        player.y = player.y + y;

        if (player.x <= 10) {
            player.x = 715;
        } else if (player.x >= 720) {
            player.x = 5;
        }


    }

    public void moveEnemy(Enemy enemy) {

        enemy.move();

    }


    public Player getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public static void playerShoot() {


        projectiles.add(new Projectile(player.x, player.y, "files/Projectile.png"));

    }

    public void moveProjectile(Projectile projectile) {

        projectile.move();
    }

    public void deleteProjectile(Projectile projectile) {

        projectiles.remove(projectile);
    }
    public void deleteEnemy(Enemy enemy){

        enemies.remove(enemy);
    }

    public void checkDestroy(Projectile projectile,Enemy enemy) {

        if (dist(projectile.x, projectile.y, enemy.x, enemy.y) <25) {

            deleteProjectile(projectile);
            deleteEnemy(enemy);


        }


    }


    public void checkPlayerDamage(Player player, Enemy enemy) {

        if (dist(player.x, player.y, enemy.x, enemy.y) < 40){

            player.getDamage();
            deleteEnemy(enemy);
            System.out.println(player.life);

        }

    }

    public void projectileBorder(Projectile projectile) {

        if (projectile.y <= 0 || projectile.y >= 720) {

            deleteProjectile(projectile);
            System.out.println(projectile + " gelöscht");



        }
    }
}

