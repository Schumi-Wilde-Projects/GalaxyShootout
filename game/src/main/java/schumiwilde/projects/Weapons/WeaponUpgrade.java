package schumiwilde.projects.Weapons;

public class WeaponUpgrade implements Weapons
{
    private Weapons myWeapon;
    public WeaponUpgrade(Weapons weapon)
    {
        this.myWeapon=weapon;
    }
    public Weapons getWeapon()
    {
        return myWeapon;
    }
    public int getDamage()
    {
        return myWeapon.getDamage();
    }
    public double getSpeed()
    {
        return myWeapon.getSpeed();
    }
    public int getAmountofBullets()
    {
        return myWeapon.getAmountofBullets();
    }

    public int getAmmountofUpgrades()
    {
        return myWeapon.getAmmountofUpgrades();
    }

}
