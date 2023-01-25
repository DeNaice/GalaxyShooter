package test.model;

import Model.GalaxyShooter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GalaxyShooterTest {
    @Test
    void PlayerShouldbeAlive(){
        var game = new GalaxyShooter(720, 720);
        assertFalse(game.isPlayerDead());
    }
    @Test
    void ShouldaddScore(){

        var game = new GalaxyShooter(720, 720);

        game.addScore();
        assertEquals(50, game.getScore());

    }
    @Test
    void ShouldmoveEnemy()  {


    }





}
