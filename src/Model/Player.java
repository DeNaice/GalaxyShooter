package Model;

/**
 * Spieler von GalaxyShooter, den man selber kontrolliert
 */

public class Player {

    /**
     *Leben des Spielers man beginnt mit 3. Sinkt Leben auf 0 ist das Spiel vorbei
     */
    public int life;
    /**
     * x und y Koordianten des Spielers
     */
    public int x;
    public int y;
    /**
     *Pfad vom Bild des Spielers als String
     */

    public String picture;
    /**
     *Größe des Spielers
     */
    public int size;

    /**
     *Konstruktur - erstellt ein Objekt Spieler
     */
    public Player(int x, int y, String picture) {

        this.x = x;
        this.y = y;
        this.life = 3;
        this.picture = picture;
        this.size = 100;


    }
    /**
     * wird getDamage aufgerufen verliert der Spieler ein Leben
     */

    public void getDamage() {

        this.life = life - 1;
    }
}
