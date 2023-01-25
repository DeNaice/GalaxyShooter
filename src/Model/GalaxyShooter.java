package Model;

import Controller.IGalaxyShooterController;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import processing.data.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static processing.core.PApplet.dist;


/**
 * Model meines GalaxyShooters
 */
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

    /**
     * Erstellt eine Instanz mit gegebener Größe
     * Spieler und ein EnemySpawner werden zum Start des Spiels instanziiert
     *
     * @param width  Breite des Spielfeldes
     * @param height Höhe des Spielfeldes
     */
    public GalaxyShooter(int width, int height) {

        this.width = width;
        this.height = height;
        //this.controller = new GalaxyShooterController(this, 720, 720);


        player = new Player(width / 2, 630, "files/Player.png");
        new EnemySpawner(this).start();


    }

    /**
     * Bewegt den Spieler nach Links, indem seine x - Koordinate weiter links gesetzt wird
     */
    public static void movePlayerLeft() {

        player.x = player.x - 10;

    }

    /**
     * Bewegt den Spieler nach Links, indem seine x - Koordinate weiter links gesetzt wird
     */
    public static void movePlayerRight() {
        player.x = player.x + 10;
    }

    /**
     * Erstellt Gegner und fügt sie der ArrayList enemies dazu
     * randomX -> Gegner wird zufällig an der x Ackse verteilt
     */
    public static void spawnEnemy() {

        int randomX = (int) (Math.random() * 700);


        enemies.add(new Enemy(randomX, 100));
        System.out.println("Enemy wird gespawnt" + enemies);

    }

    /**
     * Fügt der Projektil Arrayliste ein Projektil hinzu und gibt diesem die Koordinaten, wo der Spieler sich beim Abschuss befand
     */
    public static void playerShoot() {


        projectiles.add(new Projectile(player.x, player.y));

    }



    /**
     * moveEnemy interiert durch jeden Gegner der gesetzt wurde und bewegt sie anhand der y-Achse damit sie sich auf den Spieler zubewegen
     */

    public void moveEnemy() {

        for (Enemy enemy : enemies) {


            enemy.y = enemy.y + 2;
        }
    }

    /**
     * Iteriert durch jedes Projektil in projectiles und bewegt sie anhand der y-Achse damit sie sich auf den Gegner zubewegen
     */

    public void moveProjectile() {

        for (Projectile projectile : projectiles) {

            projectile.y = projectile.y - 2;
        }

    }

    /**
     * Löschen der Projektile durch hinzufügen in einer neuen Liste wirklich gelöscht wird erst in refresh
     */
    public void deleteProjectile(Projectile projectile) {

        newProjectiles.add(projectile);

    }

    /**
     * Löschen der Gegner durch hinzufügen in eiener neuen Liste wirklich gelöscht wird erst in refresh
     */
    public void deleteEnemy(Enemy enemy) {

        newEnemies.add(enemy);
    }

    /**
     * Für jeden Gegner wird durch jedes Projektil, dass existiert iteriert und anhand der Funktion dist die von Processing gegeben ist wird geschaut ob sie nah aneinander sind
     * sollte dies der Fall sein wird enemyHit mit dem Gegner und dem Projektil die sich nahe sind als Parameter aufgerufen
     * Gegen Ende werden mit refresh sowohl Enemy als auch Projektil Arraylisten aktualisiert, da in den Forschleifen diese nicht gelöscht werden können
     */
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

    /**
     * Iteriert über jeden Gegner und schaut ob er dem Spieler zu nahe kommt
     * Sollte dies der Fall sein wird der Gegner gelöscht durch deleteEnemy und refresh
     * Darauf wird player.getDamage aufgerufen die das Leben des Spielers um 1 reduziert
     */
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

    /**
     * aus Arraylist enemies werden alle Enemy enemy gelöscht, die in der neuen Liste newEnemies zusammengekommen sind
     */
    public void refreshEnemyList() {

        enemies.removeAll(newEnemies);

    }

    /**
     * aus Arraylist projectiles werden alle Projectile projectile gelöscht, die in der neuen Liste newProjectiles vorhanden sind
     */

    public void refreshProjectileList() {

        projectiles.removeAll(newProjectiles);
    }

    /**
     * Wenn Gegner getroffen wurde wird dieser und das Projektil gelöscht und durch addScore wird der Score um 50 addiert
     */
    public void enemyHit(Enemy enemy, Projectile projectile) {

        deleteEnemy(enemy);
        deleteProjectile(projectile);
        addScore();

    }

    /**
     * Score wird um 50 addiert
     */

    public void addScore() {

        score = score + 50;


    }

    /**
     * Gibt den Score aus
     */
    public int getScore() {

        return score;
    }

    /**
     * Boolean der true wird, wenn der Spieler tot ist ansonsten gibt er false aus
     */
    public boolean isPlayerDead() {
        if (player.life == 0) {

            return true;
        } else return false;
    }

    /**
     *
     */
    public void setDifficulty() throws InterruptedException {


        if (score > 500) {

            EnemySpawner spawner = new EnemySpawner(this);
            spawner.run();


        }

    }


    /**
     * Checkt ob sich der SPieler im Fenster befindet wenn nicht wird er auf die andere Seite bewegt
     */

    public static void checkPlayerBorder() {

        if (player.x <= 10) {
            player.x = 715;
        } else if (player.x >= 720) {
            player.x = 5;
        }

    }

    /**
     * Checkt für jeden Gegner ob dieser out of Border geht, sollte dies der Fall sein werden sie gelöscht
     */
    public void enemyBorder() {

        for (Enemy enemy : enemies) {

            if (enemy.y <= 0 || enemy.y >= 720) {

                deleteEnemy(enemy);
                System.out.println(enemy + " gelöscht");

            }

        }
        refreshEnemyList();
    }

    /**
     * Checkt für jedes Projektil ob dieses outofBorder geht. Sollte dies der Fall sein werden sie gelöscht.
     */
    public void projectileBorder() {

        for (Projectile projectile : projectiles) {

            if (projectile.y <= 0 || projectile.y >= 720) {

                deleteProjectile(projectile);
                System.out.println(projectile + " gelöscht");

            }

        }
        refreshProjectileList();
    }



    public void writeHighscore(){
        /**
         * score wird mit getScore geholt und durch einen FileWriter in die Datei HighScore.txt permanent eingetragen. WIrd nur Verändert wenn der Score dieser Runde höher als der Highscore ist
         */

        JSONObject obj = new JSONObject();

        obj.put("Highscore", getScore());

      //  if (getScore() > score) {

            try {
                fileWriter = new FileWriter("src/View/HighScore.txt");
                fileWriter.write(obj.toString());
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

      //  }



    }

    public int readHighscore(){

        JSONParser parser = new JSONParser();
        try{
            Object obj = (String)parser.parse(new FileReader("src/View/HighScore.txt"));
            JSONObject jsonObject = (JSONObject) obj;



            int highscore = (int) jsonObject.get("Highscore");

            return highscore;

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }


    }




    /**
     * Gibt Spieler zurück
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gibt die ArrayList enemies zurück
     */
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * Gibt Arraylist projectiles zurück
     */
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }


    @Override
    public String toString() {

      return ("Spielerx = "+ player.x + "Spielery = " + player.y + "SpielerLeben = " + player.life + "Anzahl von Gegnern = " + enemies.size() + "Score = " + score);
    }


}

