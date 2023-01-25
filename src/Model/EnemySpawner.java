package Model;

public class EnemySpawner extends Thread {

    private String name;
    private GalaxyShooter galaxyShooter;

    public EnemySpawner(String name, GalaxyShooter galaxyShooter) {
        this.galaxyShooter = galaxyShooter;
        this.name = name;
    }
    @Override
    public void run() {
        while (true) {
            try {
                galaxyShooter.spawnEnemy();
                int spawnerCooldown = (int) (Math.random() * 10000);
                Thread.sleep(spawnerCooldown);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}





