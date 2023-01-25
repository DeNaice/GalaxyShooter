package Controller;

import java.io.IOException;

public interface IGalaxyShooterController {
    /**
     *Interface des Controllers
     */

    /**
     * Methode wird immer aufgerufen, wenn der Controller entscheidet, was angezeigt werden soll.
     */
    void nextFrame() throws IOException;


}
