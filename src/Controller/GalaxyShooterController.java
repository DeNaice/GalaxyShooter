package Controller;

import Model.GalaxyShooter;
import processing.core.PApplet;

public class GalaxyShooterController extends PApplet implements IGalaxyShooterController {


    private GalaxyShooter model;
    private IGalaxyShooterView view;
    private GameState state;


    public GalaxyShooterController(IGalaxyShooterView view, int width, int height) {


        //TODO noch in Titlescreen umwandeln

        this.state = GameState.GAME;
        this.view = view;
        this.model = new GalaxyShooter(width, height);
       

    }


    @Override
    public void nextFrame() {
        switch (state) {
            case TITLE_SCREEN -> {
                view.drawTitleScreen();

            }
            case GAME -> {

                // Jeder Enemy Iteriert zum Registrieren
                if (model.isEnemyFilled()){
                for (var enemy : model.getEnemies()) {
                    model.moveEnemy(enemy);
                    model.checkPlayerDamage(model.getPlayer(), enemy);
                }
                }
                if (model.isProjectileFilled()){
                for (var projectile : model.getProjectiles()) {

                    model.moveProjectile(projectile);

                    if (model.isEnemyFilled()) {
                        model.projectileBorder(projectile);

                        for (var enemie : model.getEnemies()) {
                            model.checkDestroy(projectile, enemie);

                        }

                    }


                }
                }

                view.drawGame(model.getPlayer(), model.getEnemies(), model.getProjectiles());


            }
            case END_SCREEN -> view.drawEndScreen();
        }

    }



}




