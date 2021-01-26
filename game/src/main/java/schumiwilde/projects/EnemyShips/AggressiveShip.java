package schumiwilde.projects.EnemyShips;

import com.badlogic.gdx.graphics.Texture;
import schumiwilde.projects.EnemyShips.EnemyShip;
import schumiwilde.projects.Weapons.Weapons;

public class AggressiveShip extends EnemyShip {

    public AggressiveShip(boolean isRtxOn, int hp, Weapons weapon) {
        super(isRtxOn ? new Texture("img/rtxon/pngkey.com-spaceship-png-130236.png")
                : new Texture("img/rtxoff/ClipartKey_146283.png"), hp, weapon);
    }

    @Override
    public void move_() {
        if(getVX()==0)
            setVX(5);
        if(getVY()==0)
            setVY(5);
        if(getX() + getVX()<=0 || getX() + getVX()>=924)
            setVX(-getVX());
        if(getY() + getVY()<=150 || getY() + getVY()>=568)
            setVY(-getVY());
        setX(getX() + getVX());
        setY(getY() + getVY());
    }
}
