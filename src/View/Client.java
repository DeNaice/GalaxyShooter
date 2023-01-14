package View;

import Controller.GalaxyShooterController;
import Controller.IGalaxyShooterController;
import Controller.IGalaxyShooterView;
import Model.Enemy;
import Model.Player;
import processing.core.PApplet;
import processing.core.PImage;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.ServerSocket;

public class Client extends PApplet implements IGalaxyShooterView {

    public ServerSocket server = null;
    private IGalaxyShooterController controller;

    private PImage playerImage;
    private PImage[] enemyImage;
    private PImage background;
    private PImage titleScreen;
    private PImage EndScreen;


    public static void main(String args[]) {
        PApplet.main(Client.class);
    }

    public Client() {
        setSize(720, 720);
    }

    public void settings(){
    }

    public void setup(){
        this.controller = new GalaxyShooterController(this, width, height);
       // titleScreen = loadImage("");

    }




    @Override
    public void drawGame(Player player, Enemy[] enemies) {
        for (int i=0; i<enemies.length; i++){
            drawEnemy(enemies[i], i);
        }
        background(255);
        noStroke();
        fill(color(255, 100, 0));
        image(playerImage, player.x, player.y, player.size, player.size);




    }

    public void draw(){controller.nextFrame();}

    public void register(Player player, Enemy[] enemies){

        playerImage = loadImage(player.picture);
        enemyImage = new PImage[enemies.length];
        for (int i = 0; i< enemies.length; i++){
            enemyImage[i] = loadImage(enemies[i].picture);
        }

    }

    private void drawEnemy(Enemy enemy, int i){

        if (enemy.isAlive()){
            image(enemyImage[i], enemy.x, enemy.y, enemy.size, enemy.size);

        }
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

