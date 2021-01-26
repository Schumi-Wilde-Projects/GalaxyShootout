package schumiwilde.projects.EnemyShips;

import schumiwilde.projects.Weapons.Weapons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import schumiwilde.projects.player.Player;


public abstract class EnemyShip extends Sprite {
    private int HP;
    private Weapons weapon;
    private float x,y,vx=0,vy=0;

    public EnemyShip(Texture texture, int hp, Weapons weapon)
    {
        super(texture);
        this.HP=hp;
        this.weapon=weapon;
    }
    public void setXY(float x,float y)
    {
        this.x=x;
        this.y=y;
    }

    public void damage(int value) {
        HP -= value;
    }

    public int getHP() {
        return HP;
    }
    public Weapons getWeapon()
    {
        return weapon;
    }
    public float getVX()
    {
        return vx;
    }
    public void setVX(float vx)
    {
        this.vx=vx;
    }
    public float getx()
    {
        return x;
    }
    public float getVY()
    {
        return vy;
    }
    public void setVY(float vy)
    {
        this.vy=vy;
    }
    public float gety()
    {
        return y;
    }

    public abstract void move_();

    public void move() {
        move_();
    };
}

