package test.model;
import Model.GalaxyShooter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GalaxyShooterTest {
    @Test
    void ShouldSetPlayerto00(){
        var game = new GalaxyShooter(720, 720);
        assertEquals(0, game.getPlayer());
    }



}
