package schumiwilde.projects.EnemyShips;

import com.badlogic.gdx.graphics.Texture;

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
