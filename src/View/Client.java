package View;

import Controller.GalaxyShooterController;
import Controller.IGalaxyShooterController;
import Controller.IGalaxyShooterView;
import Model.Player;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.IOException;
import java.net.ServerSocket;

public class Client extends PApplet implements IGalaxyShooterView {

    public ServerSocket server = null;
    private IGalaxyShooterController controller;

    Player player;
    PImage playerImage;

    PImage background;
    PImage titleScreen;
    PImage EndScreen;


    public static void main(String args[]) {
        PApplet.main(Client.class);
    }

    public Client() {
        setSize(400, 800);
    }

    public void settings(){
    }

    public void setup(){
        this.controller = new GalaxyShooterController(this, width, height);
       // titleScreen = loadImage("");

    }




    @Override
    public void drawGame() {
        background(255);
       player =  new Player (10, 10, loadImage("files/Player.png"));


    }

    public void draw(){
        if (this.player.life >= 0){
            controller.nextFrame();




        }
    }
    @Override
    public void drawTitleScreen() {

    }

    public void keyListener(){

        if (key == CODED){
            if(keyCode == UP){
            System.out.println("Up");
            }
            if (keyCode == DOWN){
                System.out.println("Down");
            }
            if (keyCode == LEFT){
                System.out.println("Left");
            }
            if (keyCode == RIGHT){
                System.out.println("Right");
            }
            if (keyCode == 49){
                System.out.println("Spacebar");
            }
        }

    }

    @Override
    public void drawScore() {

    }




    @Override
    public void drawEndScreen() {

    }
}
