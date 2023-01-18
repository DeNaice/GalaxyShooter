package Controller;

import Model.GalaxyShooter;
import Model.Player;
import Model.Projectile;
import Model.Enemy;
import Controller.IGalaxyShooterView;
import processing.core.PApplet;
import processing.core.PImage;

public class GalaxyShooterController implements IGalaxyShooterController {


    private GalaxyShooter model;
    private IGalaxyShooterView view;
    private GameState state;


    public GalaxyShooterController(IGalaxyShooterView view, int width, int height) {


        //TODO noch in Titlescreen umwandeln

        this.state = GameState.GAME;
        this.view = view;
        this.model = new GalaxyShooter(width, height);
        this.view.registerPlayer(model.getPlayer());

    }


    @Override
    public void nextFrame() {
        switch (state) {
            case TITLE_SCREEN -> {
                view.drawTitleScreen();
            }
            case GAME -> {

                for (var e : model.getEnemies()) {

                    view.registerEnemy(e);

                }
                for (var e: model.getProjectiles()){

                    view.registerProjectile(e);
                    model.moveProjectile(e);
                }

                view.drawGame(model.getPlayer(), model.getEnemies(),model.getProjectiles());

            }
        }

    }

    @Override
    public void userInput(String direction) {

        switch (direction) {

            case "A" -> {
                model.movePlayer(-2, 0);
                System.out.println("Player nach links");
            }

            case "D" -> {
                model.movePlayer(2, 0);
                System.out.println("Player nach rechts");
            }
            case "Space" ->{model.playerShoot();


            }

        }
    }
}