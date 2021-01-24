package schumiwilde.projects.Weapons;

public class BasicWeapon implements Weapons
{
    private int Damage=1;
    private double Speed=1;
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
