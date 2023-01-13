package Controller;

import Model.GalaxyShooter;
import Model.Player;
import Model.Projectile;
import Model.Enemy;
import Controller.IGalaxyShooterView;
import processing.core.PApplet;
import processing.core.PImage;

public class GalaxyShooterController implements IGalaxyShooterController {
    int width, height;

    private GalaxyShooter model;
    private IGalaxyShooterView view;
    private GameState state;

    Player player;






    public GalaxyShooterController(IGalaxyShooterView view, int width, int height){

        this.state = GameState.TITLE_SCREEN;
        this.view = view;
        this.width = width;
        this.height = height;
        model = new GalaxyShooter(width, height);
        player = new Player(10, 10,loadImage(""));




    }


    @Override
    public void nextFrame() {

    }

    @Override
    public void userInput() {

    }
}
