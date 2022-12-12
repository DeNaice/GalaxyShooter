package View;

import Controller.GalaxyShooterController;
import Controller.IGalaxyShooterController;
import Controller.IGalaxyShooterView;
import processing.core.PApplet;
import processing.core.PImage;

public class Client extends PApplet implements IGalaxyShooterView {

    private IGalaxyShooterController controller;

    PImage player;
    PImage enemy;

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
        // titleScreen = loadImage("TitleScreen.png");
    }


    @Override
    public void drawGame() {

    }

    @Override
    public void drawScore() {

    }

    @Override
    public void drawTitleScreen() {

    }

    @Override
    public void drawEndScreen() {

    }
}
