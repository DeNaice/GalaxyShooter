package Controller;

import Model.Enemy;
import Model.Player;
import Model.Projectile;

import java.util.ArrayList;

public interface IGalaxyShooterView {

    public void drawGame(Player player, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles, int score);





    public void drawTitleScreen();

    void drawScore(int score);


    public void drawEndScreen();


}
