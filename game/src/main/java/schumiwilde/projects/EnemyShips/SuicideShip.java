package schumiwilde.projects.EnemyShips;

import com.badlogic.gdx.graphics.Texture;
import schumiwilde.projects.Weapons.Weapons;

public class SuicideShip extends EnemyShip {
    public SuicideShip(boolean isRtxOn, int hp, Weapons weapon) {
        super(isRtxOn ? new Texture("img/rtxon/pngkey.com-spaceship-png-130236.png")
                : new Texture("img/rtxoff/ClipartKey_146283.png"), hp, weapon);
    }

    @Override
    public void move_() {
        if (getVX() == 0 && getVY() == 0) {
            setVX((getX() - getx()) / 50);
            setVY((getY() - gety()) / 50);
        }
        setX(getX() - getVX());
        setY(getY() - getVY());
    }
}
