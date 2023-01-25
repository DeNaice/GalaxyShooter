package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Controller.GalaxyShooterController;
import Controller.IGalaxyShooterController;
import Controller.IGalaxyShooterView;
import View.Server;
import processing.core.PApplet;
import processing.data.JSONObject;

import static processing.core.PApplet.dist;


// Für die Funktion dist
public class GalaxyShooter {

    private static Player player;

    private FileWriter fileWriter;
    private FileReader fileReader;

    private static ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Enemy> newEnemies = new ArrayList<>();

    private static ArrayList<Projectile> projectiles = new ArrayList<>();
    private static ArrayList<Projectile> newProjectiles = new ArrayList<>();

    private IGalaxyShooterController controller;


    private int score = 0;


    int width, height;


    public GalaxyShooter(int width, int height) {

        this.width = width;
        this.height = height;
        //this.controller = new GalaxyShooterController(this, 720, 720);


        player = new Player(width / 2, 630, "files/Player.png");
        new EnemySpawner(this).start();


    }


    public static void movePlayerLeft() {

        player.x = player.x - 10;

    }

    public static void movePlayerRight() {
        player.x = player.x + 10;
    }


    public static void spawnEnemy() {

        int randomX = (int) (Math.random() * 700);


        enemies.add(new Enemy(randomX, 100));
        System.out.println("Enemy wird gespawnt" + enemies);

    }

    public static void playerShoot() {


        projectiles.add(new Projectile(player.x, player.y, "files/Projectile.png"));

    }


    public void moveEnemy() {

        for (Enemy enemy : enemies) {


            enemy.y = enemy.y + 2;
        }
    }


    public void moveProjectile() {

        for (Projectile projectile : projectiles) {

            projectile.y = projectile.y - 2;
        }

    }

    public void deleteProjectile(Projectile projectile) {

        newProjectiles.add(projectile);

    }

    public void deleteEnemy(Enemy enemy) {

        newEnemies.add(enemy);
    }

    public void checkDestroy() {
        for (Enemy enemy : enemies) {

            for (Projectile projectile : projectiles) {


                if (dist(projectile.x, projectile.y, enemy.x, enemy.y) < 15) {


                    enemyHit(enemy, projectile);


                }
            }
        }
        refreshEnemyList();
        refreshProjectileList();

    }


    public void damagePlayer() {

        for (Enemy enemy : enemies) {


            if (dist(player.x, player.y, enemy.x, enemy.y) < 40) {

                player.getDamage();
                deleteEnemy(enemy);
                System.out.println(player.life);

            }
        }
        refreshEnemyList();


    }


    public void refreshEnemyList() {

        enemies.removeAll(newEnemies);

    }

    public void refreshProjectileList() {

        projectiles.removeAll(newProjectiles);
    }

    public void enemyHit(Enemy enemy, Projectile projectile) {

        deleteEnemy(enemy);
        deleteProjectile(projectile);
        addScore();

    }

    public void addScore() {

        score = score + 50;


    }

    public int getScore() {

        return score;
    }

    public boolean isPlayerDead() {
        if (player.life == 0) {

            return true;
        } else return false;
    }

    public void setDifficulty() throws InterruptedException {


        if (score > 500) {

            EnemySpawner spawner = new EnemySpawner(this);
            spawner.run();


        }

    }


    public int sendScore() {

        return score;


    }

    public static void checkPlayerBorder() {

        if (player.x <= 10) {
            player.x = 715;
        } else if (player.x >= 720) {
            player.x = 5;
        }

    }


    public void enemyBorder() {

        for (Enemy enemy : enemies) {

            if (enemy.y <= 0 || enemy.y >= 720) {

                deleteEnemy(enemy);
                System.out.println(enemy + " gelöscht");

            }

        }
        refreshEnemyList();
    }

    public void projectileBorder() {

        for (Projectile projectile : projectiles) {

            if (projectile.y <= 0 || projectile.y >= 720) {

                deleteProjectile(projectile);
                System.out.println(projectile + " gelöscht");

            }

        }
        refreshProjectileList();
    }

    public void writeHighscore() throws IOException {

        JSONObject obj = new JSONObject();
        obj.put("Highscore", score);

        fileWriter = new FileWriter("src/View/HighScore.txt");


    }

    public void readHighscore() {


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


}

