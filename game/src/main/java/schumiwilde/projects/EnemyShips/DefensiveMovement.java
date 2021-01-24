package schumiwilde.projects.EnemyShips;

public class DefensiveMovement implements EnemyMovements {
    public void move(EnemyShip enemy) {
        if(enemy.getVX()==0)
            enemy.setVX(5);
        if(enemy.getX() + enemy.getVX()<=0 || enemy.getX() + enemy.getVX()>=924)
            enemy.setVX(-enemy.getVX());
        if(enemy.getY() + enemy.getVY()<=0 || enemy.getY() + enemy.getVY()>=768)
            enemy.setVY(-enemy.getVY());
        enemy.setX(enemy.getX() + enemy.getVX());
        enemy.setY(enemy.getY() + enemy.getVY());
    }
}
