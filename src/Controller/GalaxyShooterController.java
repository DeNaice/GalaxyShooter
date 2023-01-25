package Controller;

import Model.GalaxyShooter;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Der Controller des GalaxyShooters
 */
public class GalaxyShooterController implements IGalaxyShooterController {


    private GalaxyShooter model;
    private IGalaxyShooterView view;
    private GameState state;


    /**
     * Contoller wird erstellt der über view model und Gamestate zugreifen kann
     */

    public GalaxyShooterController(IGalaxyShooterView view, int width, int height) {


        //TODO noch in Titlescreen umwandeln

        this.state = GameState.TITLE_SCREEN;
        this.view = view;
        this.model = new GalaxyShooter(width, height);


    }

    /**
     * Regelt die Verschiedenen States des Spiels
     * TitleScreen → Bevor da Spiel losgeht
     * Game ist während des Spiels, dass auch die gameloop und die drawGame methode beinhält
     * End_Screen → Sollte der Spieler sterben wird er an den EndScreen weitergegeben
     */
    @Override
    public void nextFrame() throws IOException {


        switch (state) {
            case TITLE_SCREEN -> {


                view.drawTitleScreen();


            }
            case GAME -> {
                gameLoop();
                view.drawGame(model.getPlayer(), model.getEnemies(), model.getProjectiles(), model.getScore());
            }
            case END_SCREEN -> {



                view.drawEndScreen();
                view.drawHighscore(model.getScore(), 300);

            }
        }
    }

    /**
     * Bei LeerTaste wird geprüft ob man sich in den States TitleSreen oder EndScreen befindet sollte dies
     * der fall sein kommt man weiter sodass ein guter Spielfluss entsteht
     */
    @Override
    public void updateState() {

        if (state == GameState.TITLE_SCREEN){

            state = GameState.GAME;

        }
        else if (state == GameState.END_SCREEN) {

            state = GameState.TITLE_SCREEN;

        }

    }

    /**
     *Hier befindet sich die Game-Loop die in case Game stattfindet ausgelagert zur Übersichtlichkeit
     */
    public void gameLoop() throws FileNotFoundException {

        model.moveEnemy();
        model.moveProjectile();
        model.damagePlayer();
        model.projectileBorder();
        model.enemyBorder();
        model.checkDestroy();
        if (model.isPlayerDead()) {
            model.writeHighscore();
           // view.drawHighscore(model.readHighscore());

            this.state = GameState.END_SCREEN;
        }


    }
}












