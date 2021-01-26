package schumiwilde.projects.EnemyShips;

import com.badlogic.gdx.graphics.Texture;

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

    @Override
    public void setRtxOn(EnemyShip ship) {
        ship.setTexture(getRtxOn());
    }

    @Override
    public void setRtxOff(EnemyShip ship) {
        ship.setTexture(getRtxOff());
    }

    @Override
    public Texture getRtxOn() {
        return new Texture("img/rtxon/pngkey.com-spaceship-png-130236.png");
    }

    @Override
    public Texture getRtxOff() {
        return new Texture("img/rtxoff/ClipartKey_146283.png");
    }
}
