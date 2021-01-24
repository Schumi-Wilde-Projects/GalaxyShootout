package schumiwilde.projects.EnemyShips;

import schumiwilde.projects.Weapons.Weapons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import schumiwilde.projects.player.Player;


public class EnemyShip extends Sprite {
    private int HP;
    private Weapons weapon;
    private float x,y,vx=0,vy=0;
    private EnemyMovements movement;
    public EnemyShip(Texture texture,int hp,Weapons weapon,EnemyMovements movement)
    {
        super(texture);

        this.HP=hp;
        this.weapon=weapon;
        this.movement=movement;

    }
    public void setXY(float X,float Y)
    {
        this.x=x;
        this.y=y;
    }
    public void setRtxOn() {
        setTexture(new Texture("img/rtxon/pngkey.com-spaceship-png-130236.png"));
    }

    public void setRtxOff() {
        setTexture(new Texture("img/rtxoff/ClipartKey_146283.png"));
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
    public void move()
    {
        movement.move(this);
    }
}

