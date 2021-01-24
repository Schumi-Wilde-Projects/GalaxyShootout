package schumiwilde.projects.EnemyShips;

import com.badlogic.gdx.graphics.Texture;
import schumiwilde.projects.Weapons.Weapons;

public class AgresiveShip extends EnemyShip {
    public AgresiveShip(Texture texture, int hp, Weapons weapon) {
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
    public void move() {
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

