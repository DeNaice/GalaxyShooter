package Model;

import java.util.ArrayList;

import processing.core.PApplet;




public class GalaxyShooter extends PApplet {

    private static Player player;

    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Enemy> newEnemies = new ArrayList<>();

    private static ArrayList<Projectile> projectiles = new ArrayList<>();
    private static ArrayList<Projectile> newProjectiles = new ArrayList<>();

    private int score = 0;


    int width, height;
    int velocity = 2;


    public GalaxyShooter(int width, int height) {

        this.width = width;
        this.height = height;

        player = new Player(width / 2, 630, "files/Player.png");


        enemies.add(new Enemy(100, 100));


    }


    public static void movePlayerLeft() {

        player.x = player.x - 10;

    }

    public static void movePlayerRight() {
        player.x = player.x + 10;
    }

    public static void checkPlayerBorder() {

        if (player.x <= 10) {
            player.x = 715;
        } else if (player.x >= 720) {
            player.x = 5;
        }

    }


    public void moveEnemy() {

        for (Enemy enemy : enemies) {


            enemy.y = enemy.y + 1;
        }
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

    public void projectileBorder() {

        for (Projectile projectile : projectiles) {

            if (projectile.y <= 0 || projectile.y >= 720) {

                deleteProjectile(projectile);
                System.out.println(projectile + " gelöscht");

            }

        }
        refreshProjectileList();
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


}

