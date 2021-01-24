package schumiwilde.projects.Weapons;

public class RocketWeapon implements Weapons
{
    private int Damage=1;
    private double Speed=0.5;
    private int Bullets=4;
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
