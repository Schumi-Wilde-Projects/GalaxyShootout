package schumiwilde.projects.EnemyShips;

public class SuicudeMovement implements EnemyMovements {
    public SuicudeMovement() {

    }

    public void move(EnemyShip enemy) {
        if (enemy.getVX() == 0 && enemy.getVY() == 0) {
            enemy.setVX((enemy.getX() - enemy.getx()) / 50);
            enemy.setVY((enemy.getY() - enemy.gety()) / 50);
        }
        enemy.setX(enemy.getX() - enemy.getVX());
        enemy.setY(enemy.getY() - enemy.getVY());

    }
}
