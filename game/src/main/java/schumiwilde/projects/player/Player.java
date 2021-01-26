package schumiwilde.projects.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends Sprite {

    private static Player instance;
    private int HP;
    private int currentLevel;
    private int armorPoints;

    public static Player getInstance() {
        if(instance == null)
            instance = new Player(new Texture("img/rtxoff/ClipartKey_146283.png"));
        return instance;
    }

    public void setRtxOn() {
        setTexture(new Texture("img/rtxon/pngkey.com-spaceship-png-130236.png"));
    }

    public void setRtxOff() {
        setTexture(new Texture("img/rtxoff/ClipartKey_146283.png"));
    }

    public Player reset() {
        this.HP = 6;
        this.currentLevel = 1;
        this.armorPoints = 0;
        return this;
    }

    private Player(Texture texture) {
        super(texture);
        this.HP = 6;
        this.currentLevel = 1;
        this.armorPoints = 0;
    }

    public int getHP() {
        return HP;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public void move(float x) {
        setX(getX() + x);
    }

    public void moveY(float y) {
        setY(getY() + y);
    }
}
