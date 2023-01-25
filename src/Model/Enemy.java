package Model;

/**
 * Die Gegner Klasse enthält alle wichtigen Informationen die den Gegner ausmachen
 */
public class Enemy {
    /**
     * Koordinaten des Gegners
     */
    public int x;
    public int y;
    /**
     * Leben des Gegners ist auf 1 gestellt damit man bei Bedarf Schwierigere Gegner erstellen kann
     */
    public int life;
    /**
     * Pfad des Bildes als String
     */
    public String picture;
    /**
     * Größe des einzelnen Gegners
     */
    public int size;

    /**
     * Konstruktor - Erstekkt ein Objekt Gegner
     */

    public Enemy(int x, int y) {

        this.x = x;
        this.y = y;
        this.picture = "files/Enemy.png";
        this.life = 1;
        this.size = 50;


    }
}


