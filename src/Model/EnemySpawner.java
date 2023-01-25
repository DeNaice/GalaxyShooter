package Model;

public class EnemySpawner extends Thread {


    private GalaxyShooter galaxyShooter;

    public EnemySpawner(GalaxyShooter galaxyShooter) {
        this.galaxyShooter = galaxyShooter;

    }

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





