package Controller;

import Model.Enemy;
import Model.Player;

public interface IGalaxyShooterView {

    public void drawGame(Player player, Enemy[] enemies);

    void register(Player player, Enemy[] enemies);

    public void drawScore();

    public void drawTitleScreen();

    public void drawEndScreen();


}
