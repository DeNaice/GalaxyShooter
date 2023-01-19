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
        image(playerImage, player.x - 50, player.y, player.size, player.size);
        if (mouseButton == LEFT) {
            System.out.println("x= "+ mouseX +"y= "+  mouseY);
        }

        for (var e: enemies){

            image(enemyImage, e.x ,e.y ,e.size, e.size);

        }
        for (var e: projectiles){

            image(projectileImage, e.x- 11, e.y -10, e.size, e.size);
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

