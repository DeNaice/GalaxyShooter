package Controller;

import Model.EnemySpawner;
import Model.GalaxyShooter;
import View.Server;
import processing.core.PApplet;

public class GalaxyShooterController extends PApplet implements IGalaxyShooterController {


    private GalaxyShooter model;
    private IGalaxyShooterView view;
    private GameState state;

    private Server server;





    public GalaxyShooterController(IGalaxyShooterView view, int width, int height) {


        //TODO noch in Titlescreen umwandeln

        this.state = GameState.GAME ;
        this.view = view;
        this.model = new GalaxyShooter(width, height);



    }


    @Override
    public void nextFrame() {
        switch (state) {
            case TITLE_SCREEN -> {
                view.drawTitleScreen();
                if (keyPressed) {
                    state = GameState.GAME;
                }
            }
            case GAME -> {
                gameLoop();
                view.drawGame(model.getPlayer(), model.getEnemies(), model.getProjectiles(), model.getScore());
            }
            case END_SCREEN -> {


                view.drawEndScreen();

            }
        }
    }

    public void gameLoop(){

        model.moveEnemy();
        model.moveProjectile();
        model.damagePlayer();
        model.projectileBorder();
        model.checkDestroy();
        if (model.isPlayerDead()) {
            view.sendScore(model.sendScore());
            this.state = GameState.END_SCREEN;
        }




    }
}












