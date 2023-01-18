package Controller;

import Model.Enemy;
import Model.Player;
import Model.Projectile;

import java.util.ArrayList;

public interface IGalaxyShooterView {

    public void drawGame(Player player, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles);

    void registerPlayer(Player player);
    void registerEnemy(Enemy enemy);
    void registerProjectile(Projectile projectile);

    public void drawScore();

    public void drawTitleScreen();

    public void drawEndScreen();




}
