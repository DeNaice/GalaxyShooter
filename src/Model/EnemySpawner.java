package Model;

/**
 * Hier ist der EnemySpawner
 * Dieser ist ein Thread
 */
public class EnemySpawner extends Thread {


    public EnemySpawner(GalaxyShooter galaxyShooter) {

    }

    /**
     * Wenn der Thread läuft soll er einen Gegner spawnen und dann mit sleep eine Zeit von 0s bis 10s warten bevor er erneut einen Gegner spawnt
     */
    @Override
    public void run() {
        while (true) {
            try {
                GalaxyShooter.spawnEnemy();
                int spawnerCooldown = (int) (Math.random() * 10000);
                Thread.sleep(spawnerCooldown);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}





