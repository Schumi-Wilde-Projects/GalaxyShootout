package schumiwilde.projects.EnemyShips;

import com.badlogic.gdx.graphics.Texture;

public interface EnemyMovements {
    public void move(EnemyShip enemy);
    void setRtxOn(EnemyShip ship);
    void setRtxOff(EnemyShip ship);
    Texture getRtxOn();
    Texture getRtxOff();
}
