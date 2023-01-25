package Controller;

import Model.Enemy;
import Model.Player;
import Model.Projectile;

import java.util.ArrayList;

/**
 * Alle nötigen Klassen des Views, damit dieser vom Controller genutzt werden können
 */
public interface IGalaxyShooterView {
    /**
     * Hier werden der Spieler die Liste der Gegner, die Liste der Projektile und des Scores weitergegeben, damit diese jeden Frame gezeichnet werden können
     */

    public void drawGame(Player player, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles, int score);

    /**
     * Damit der TitleScreen gezeichnet werden kann
     */
    public void drawTitleScreen();

    /**
     * score wird als Integer weitergegeben
     */

    void drawScore(int score);

    /**
     * Zeichnet den Endscreen
     */

    public void drawEndScreen();

    /**
     * sendet score
     */
    void sendScore(int score);
}
