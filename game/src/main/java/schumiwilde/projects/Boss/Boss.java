package schumiwilde.projects.Boss;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import schumiwilde.projects.Weapons.Weapons;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Boss extends Sprite {
    private int HP;
    private Weapons weapon1,weapon2,weapon3;
    private float vx=0,vy=0;
    private BossMovment movement;
    public Boss(Texture texture, int hp)
    {
        super(texture);
        this.HP=hp;

    }
    public void setRtxOn() {
        setTexture(new Texture("img/rtxon/pngkey.com-spaceship-png-130236.png"));
    }
    public void setWeapons(Weapons weapon1,Weapons weapon2,Weapons weapon3)
    {
        this.weapon1=weapon1;
        this.weapon1=weapon2;
        this.weapon1=weapon3;
    }
    public void setMovement(BossMovment move)
    {
        this.movement=move;
    }
    public float getVY()
    {
        return vy;
    }
    public float getVX()
    {
        return vx;
    }
    public void setVX(float vx)
    {
        this.vx=vx;
    }
    public void setVY(float vy)
    {
        this.vy=vy;
    }
    public void move()
    {
        movement.move(this);
    }
    public int getHP() {
        return HP;
    }
    public Weapons getWeapon1()
    {
        return weapon1;
    }
    public Weapons getWeapon2()
    {
        return weapon2;
    }
    public Weapons getWeapon3()
    {
        return weapon3;
    }
}
