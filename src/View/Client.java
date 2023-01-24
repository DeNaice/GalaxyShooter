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
import java.util.ArrayList;

public class Client extends PApplet implements IGalaxyShooterView {

    private IGalaxyShooterController controller;

    private final int WIDTH = 720;
    private final int HEIGHT = 720;
    private PImage playerImage;
    private PImage enemyImage;
    private PImage projectileImage;
    private PImage background;
    private PImage titleScreen;
    private PImage endScreen;


    public static void main(String args[]) {
        PApplet.main(Client.class);
    }

    public Client() {
        setSize(WIDTH, HEIGHT);
    }

    public void settings() {

        pixelDensity(2);
    }

    public void setup() {
        this.controller = new GalaxyShooterController(this, width, height);



        playerImage = loadImage("files/Player.png");
        enemyImage = loadImage("files/Enemy.png");
        projectileImage = loadImage("files/Projectile.png");



        // titleScreen = loadImage("");

    }


    @Override
    public void drawGame(Player player, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles) {

        noStroke();
        background(150, 145, 135);
        image(playerImage, player.x - 50, player.y, player.size, player.size);
        drawScore();

        // TODO When NULL
        if (!enemies.isEmpty()) {
            for (var e : enemies) {
                image(enemyImage, e.x - 25, e.y, e.size, e.size);

            }
        }

        // TODO When NULL ?
        if (!projectiles.isEmpty()) {
            for (var e : projectiles) {


                image(projectileImage, e.x - 10, e.y, e.size, e.size);
            }
        }
    }


    public void draw() {
        controller.nextFrame();
    }






    @Override
    public void drawTitleScreen() {
        titleScreen = loadImage("files/TitleScreen.png");
        image(titleScreen, 0, 0,width, height);
      //  GalaxyShooter.checkStartGame();

    }


    @Override
    public void drawScore() {
        int score = 0;
        fill(255,255,255);
        textSize(20);
        text("Score: " + score,25, 30);

    }


    @Override
    public void drawEndScreen() {
        endScreen = loadImage("files/EndScreen.png");
        image(endScreen, 0, 0,width, height);

    }

    public void keyPressed() {


        if (CODED == 65535) {



            switch (keyCode) {

                case KeyEvent.VK_A:
                    GalaxyShooter.movePlayer(-10, 0);
                    break;
                case KeyEvent.VK_D:
                    GalaxyShooter.movePlayer(10, 0);
                    break;
                case KeyEvent.VK_SPACE:
                    GalaxyShooter.playerShoot();
                    break;
            }


        }
    }


}

