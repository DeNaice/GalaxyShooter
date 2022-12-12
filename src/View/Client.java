package View;

import processing.core.PApplet;
import processing.core.PImage;

public class Client extends PApplet implements IView {

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
        // Controller instanziieren

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
