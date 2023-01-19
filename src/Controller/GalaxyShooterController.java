package Controller;

import Model.GalaxyShooter;
import Model.Player;
import Model.Projectile;
import Model.Enemy;
import Controller.IGalaxyShooterView;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.event.KeyEvent;

public class GalaxyShooterController extends PApplet implements IGalaxyShooterController {


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

                // Jeder Enemy Iteriert zum Registrieren
                for (var enemy : model.getEnemies()) {
                    view.registerEnemy(enemy);
                    model.moveEnemy(enemy);
                    model.checkPlayerDamage(model.getPlayer(), enemy);


                }

                for (var projectile : model.getProjectiles()) {

                    view.registerProjectile(projectile);
                    model.moveProjectile(projectile);

                    for (var enemie : model.getEnemies()) {
                        model.checkDestroy(projectile, enemie);

                    }
                    model.projectileBorder(projectile);

                }

                view.drawGame(model.getPlayer(), model.getEnemies(), model.getProjectiles());


            }
        }

    }

}




