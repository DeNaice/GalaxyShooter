package Model;

public class GalaxyShooter {

  private Player player;

    private Enemy[] enemies;

    Projectile[] projectiles;

    int width, height;
    int velocity = 2;


    public GalaxyShooter(int width, int height){

        this.width = width;
        this.height = height;

        enemies = new Enemy[]{

          new Enemy(500, 500,1,"files/Enemy.png")


        };

        player = new Player(width / 2, height/2, "files/Player.png");


    }

    public void movePlayer(int x, int y) {


            player.x = player.x + x;
            player.y = player.y + y;



    }

    public void moveEnemy(Enemy enemy){



    }



    public Player getPlayer() {return player;}

    public Enemy[] getEnemies(){return enemies;}

    public void playerShoot(){

        int x = player.x;
        int y = player.y;

        projectiles = new Projectile()

    }

}
