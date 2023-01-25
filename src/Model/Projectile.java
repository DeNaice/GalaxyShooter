package Model;
/**
 *Klasse Projektil das erstellt wird, wenn der Spieler schießt
 */
public class Projectile {
    /**
     *Koordinaten des Projektils
     */
    public int x;
    public int y;

    /**
     *Pfad des Bildes des Projektils als String
     */

    public String picture;
    /**
     *Größe des Projektils
     */

    public int size;

    /**
     *Konstruktor des Projektils hier werden die Projektile erstellt
     */
    public Projectile(int x, int y, String picture) {

        this.x = x;
        this.y = y;
        this.picture = picture;
        this.size = 20;

    }

}
