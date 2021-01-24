package schumiwilde.projects.EnemyShips;

import com.badlogic.gdx.graphics.Texture;
import schumiwilde.projects.Weapons.Weapons;

public class SuicudeShip extends EnemyShip {


    public SuicudeShip(Texture texture, int hp, Weapons weapon) {
        super(texture, hp, weapon);
    }

    @Override
    public void setRtxOn() {

        setTexture(new Texture("img/rtxon/pngkey.com-spaceship-png-130236.png"));

    }

    @Override
    public void setRtxOff() {
        setTexture(new Texture("img/rtxoff/ClipartKey_146283.png"));
    }

    @Override
    public void move() {
        if (getVX() == 0 && getVY() == 0) {
            setVX((getX() - getx()) / 50);
            setVY((getY() - gety()) / 50);
        }
        setX(getX() - getVX());
        setY(getY() - getVY());
    }
}
