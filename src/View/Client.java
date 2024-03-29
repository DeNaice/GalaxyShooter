package View;

import Controller.GalaxyShooterController;
import Controller.IGalaxyShooterController;
import Controller.IGalaxyShooterView;
import Model.Enemy;
import Model.GalaxyShooter;
import Model.Player;
import Model.Projectile;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
/**
 * View des Spiels GalaxyShooter
 * hier wird das Visuelle des Spiels gehandelt
 */

public class Client extends PApplet implements IGalaxyShooterView {

    private IGalaxyShooterController controller;
    private Socket socket = null;
    private PrintWriter writer = null;
    private BufferedReader reader = null;

    private final int WIDTH = 720;
    private final int HEIGHT = 720;
    private PImage playerImage;
    private PImage playerLife;
    private PImage enemyImage;
    private PImage projectileImage;

    private PImage titleScreen;
    private PImage endScreen;


    public static void main(String args[]) {
        PApplet.main(Client.class);
    }

    public Client() {
        setSize(WIDTH, HEIGHT);
    }

    public void settings() {

    }

    /**
     *In Setup wird ein Kontroller in dieser Instanz erstellt
     * Daruber werden alle benötigsten Bilder geladen
     * playerImage, ProjektilImage und playerLife wurden selbst mit der Pixeldesign Software Aseprite designt
     * titleScreen und endScreen würden über www.canva.com designt
     */
    public void setup() {
        this.controller = new GalaxyShooterController(this, width, height);


        playerImage = loadImage("files/Player.png");
        enemyImage = loadImage("files/Enemy.png");
        projectileImage = loadImage("files/Projectile.png");
        titleScreen = loadImage("files/TitleScreen.png");
        endScreen = loadImage("files/EndScreen.png");
        playerLife = loadImage("files/Heart.png");

    }

    /**
     *Hier wird jeden Frame das Spiel gezeichnet
     * jeden Frame wird der Spieler, das Leben und der Score dargestellt
     * Für Gegner und Projektile werden über die Listen enemies und projectiles iteriert und jeder Eintrag wird mit image gezeichnet
     */
    @Override
    //statt player 2 integers mit x und y
    public void drawGame(Player player, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles, int score) {

        noStroke();
        background(150, 145, 135);
        image(playerImage, player.x - 50, player.y, player.size, player.size);
        drawScore(score);
        drawPlayerLife(player);

        for (var e : enemies) {
            image(enemyImage, e.x - 25, e.y, e.size, e.size);

        }

        for (var e : projectiles) {

            image(projectileImage, e.x - 10, e.y, e.size, e.size);
        }


    }


    public void draw() {
        try {
            controller.nextFrame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TitleScreen wird gezeichnet und auf den ganzen Bildschirm gezeigt
     */
    @Override
    public void drawTitleScreen() {
        image(titleScreen, 0, 0, width, height);


    }

    /**
     * drawScore zeigt jeden Frame den Score an
     * @param score wird übergeben und mithilfe von text dargestellt
     */
    @Override
    public void drawScore(int score) {

        fill(0, 0, 0);
        textSize(20);
        text("Score: " + score, 25, 30);

    }

    /**
     * drawPlayerLife ist für die Anzeige des Lebens zust#ndig
     * @param player wird übergeben, damit man an sein Leben kommt
     * je nach Anzahl der Leben werden 3, 2 oder nur 1 Herz dargestellt
     * zu 0 Herzen kommen wir nicht da da direkt zum GameState EndScreen gewechselt wird
     */
    public void drawPlayerLife(Player player) {

        if (player.life == 3) {
            image(playerLife, 550, 10, 40, 40);
            image(playerLife, 600, 10, 40, 40);
            image(playerLife, 650, 10, 40, 40);


        } else if (player.life == 2) {
            image(playerLife, 550, 10, 40, 40);
            image(playerLife, 600, 10, 40, 40);
        } else if (player.life == 1) {
            image(playerLife, 550, 10, 40, 40);
        }

    }

    /**
     * Endscreen wird gezeichnet
     */
    @Override
    public void drawEndScreen() {

        image(endScreen, 0, 0, width, height);

    }


    @Override
    public void drawHighscore(int yourScore, int readHighscore) {

        fill(0, 0, 0);
        textSize(30);
        text("Dein Score: " + yourScore, width/2 -100, height/2);

        text("Hightscore: " + readHighscore, width/2 -100 , height/2 + 50);





    }


    /**
     * Da Client PApplet extended hat man hier zugriff auf die Methode keyPressed die checkt ob eine Taste gedrückt wird
     * sollte dies der Fall sein wird in switch case geschaut ob es a, d , oder Space ist.
     * Diese sind zur Bedienung des Spiels benötigt
     */
    public void keyPressed() {


        if (CODED == 65535) {


            switch (keyCode) {


                case KeyEvent.VK_A:
                    GalaxyShooter.movePlayerLeft();
                    break;
                case KeyEvent.VK_D:
                    GalaxyShooter.movePlayerRight();
                    break;
                case KeyEvent.VK_SPACE:
                    controller.updateState();


                    GalaxyShooter.playerShoot();
                    break;

            }

            GalaxyShooter.checkPlayerBorder();

        }

    }


}

