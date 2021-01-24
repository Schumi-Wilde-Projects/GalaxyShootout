package schumiwilde.projects.Weapons;

public class PlasmaWeapon implements Weapons
{
    private int Damage=2;
    private double Speed=2;
    private int Bullets=1;
    public int getDamage()
    {
        return Damage;
    }
    public double getSpeed()
    {
        return Speed;
    }
    public int getAmountofBullets()
    {
        return Bullets;
    }
    public int getAmmountofUpgrades()
    {
        return 0;
    }
}
