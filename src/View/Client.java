package View;

import Controller.GalaxyShooterController;
import Controller.IGalaxyShooterController;
import Controller.IGalaxyShooterView;
import Model.Enemy;
import Model.Player;
import Model.Projectile;
import processing.core.PApplet;
import processing.core.PImage;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.*;

public class Client extends PApplet implements IGalaxyShooterView {

    private IGalaxyShooterController controller;

    private final int WIDTH = 720;
    private final int HEIGHT = 720;
    private PImage playerImage;
    private PImage enemyImage;
    private PImage projectileImage;
    private PImage background;
    private PImage titleScreen;
    private PImage EndScreen;


    public static void main(String args[]) {
        PApplet.main(Client.class);
    }

    public Client() {
        setSize(WIDTH, HEIGHT);
    }

    public void settings(){
    }

    public void setup(){
        this.controller = new GalaxyShooterController(this, width, height);
       // titleScreen = loadImage("");

    }




    @Override
    public void drawGame(Player player, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles) {


        background(255);
        noStroke();
        fill(color(255, 100, 0));
        image(playerImage, player.x, player.y, player.size, player.size);

        for (var e: enemies){

            image(enemyImage, e.x,e.y,e.size, e.size);

        }
        for (var e: projectiles){

            image(projectileImage, e.x, e.y, e.size, e.size);
        }

    }



    public void draw(){controller.nextFrame();}

    public void registerPlayer(Player player){

        playerImage = loadImage(player.picture);

    }
    public void registerEnemy(Enemy enemy){

        enemyImage = loadImage(enemy.picture);

    }

    public void registerProjectile(Projectile projectile){

        projectileImage = loadImage(projectile.picture);

    }

    public void drawEnemy(Enemy enemy){

        //if (enemy.isAlive()){
            image(enemyImage, enemy.x, enemy.y, enemy.size, enemy.size);
        System.out.println("");

        //}
    }

    @Override
    public void drawTitleScreen() {


    }



    @Override
    public void drawScore() {

    }




    @Override
    public void drawEndScreen() {

    }

    public void keyPressed() {

        if (CODED == 65535) {
            switch (keyCode) {
                case KeyEvent.VK_A:
                    controller.userInput("A");
                    break;
                case KeyEvent.VK_D:
                    controller.userInput("D");
                    break;

                case KeyEvent.VK_SPACE:
                    controller.userInput("Space");
            }
        }
    }

}

