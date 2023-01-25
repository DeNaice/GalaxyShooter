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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

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

        pixelDensity(2);
    }

    public void setup() {
        this.controller = new GalaxyShooterController(this, width, height);


        playerImage = loadImage("files/Player.png");
        enemyImage = loadImage("files/Enemy.png");
        projectileImage = loadImage("files/Projectile.png");
        titleScreen = loadImage("files/TitleScreen.png");
        endScreen = loadImage("files/EndScreen.png");
        playerLife = loadImage("files/Heart.png");


        /*
        try{
            connectClient();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        */
    }


    @Override
    public void drawGame(Player player, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles, int score) {

        noStroke();
        background(150, 145, 135);
        image(playerImage, player.x - 50, player.y, player.size, player.size);
        drawScore(score);

        for (var e : enemies) {
            image(enemyImage, e.x - 25, e.y, e.size, e.size);

        }

        for (var e : projectiles) {

            image(projectileImage, e.x - 10, e.y, e.size, e.size);
        }

       drawPlayerLife(player);
    }


    public void draw() {
        controller.nextFrame();
    }


    @Override
    public void drawTitleScreen() {
        image(titleScreen, 0, 0, width, height);
        //  GalaxyShooter.checkStartGame();

    }


    @Override
    public void drawScore(int score) {

        fill(0, 0, 0);
        textSize(20);
        text("Score: " + score, 25, 30);

    }
    public void drawPlayerLife(Player player){

        if (player.life == 3){
            image(playerLife, 550, 10,40, 40);
            image(playerLife, 600, 10, 40, 40);
            image(playerLife, 650, 10, 40, 40);


        }
        else if (player.life == 2){
            image(playerLife, 550, 10,40, 40);
            image(playerLife, 600, 10, 40, 40);
        }
        else if (player.life == 1){
            image(playerLife, 550, 10,40, 40);
        }

    }




    @Override
    public void drawEndScreen() {

        image(endScreen, 0, 0, width, height);

    }

    @Override
    public void sendScore(int score) {

    }

    public void connectClient() throws IOException {

        String ip = "localhost";
        int port = 8080;
        socket = new Socket(ip, port);
        writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("CONNECTED");
        System.out.println("CONNECTED");
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));


    }

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
                    GalaxyShooter.playerShoot();
                        break;

            }

            GalaxyShooter.checkPlayerBorder();

        }

    }



}

