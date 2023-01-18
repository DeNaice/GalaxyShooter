package Controller;

import Model.Enemy;
import Model.Player;

import java.util.ArrayList;

public interface IGalaxyShooterView {

    public void drawGame(Player player, ArrayList<Enemy> enemies );

    void registerPlayer(Player player);

    public void drawScore();

    public void drawTitleScreen();

    public void drawEndScreen();


    void registerEnemy(Enemy e);

}
