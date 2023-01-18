package Controller;

import Model.Enemy;
import Model.Player;

import java.util.ArrayList;

public interface IGalaxyShooterView {

    public void drawGame(Player player, ArrayList<Enemy> enemies);

    void register(Player player, ArrayList<Enemy> enemies);

    public void drawScore();

    public void drawTitleScreen();

    public void drawEndScreen();


}
