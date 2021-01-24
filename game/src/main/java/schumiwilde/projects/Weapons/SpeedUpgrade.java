package schumiwilde.projects.Weapons;

public class SpeedUpgrade extends WeaponUpgrade
{
    public SpeedUpgrade(Weapons weapon)
    {
        super(weapon);
    }

    @Override
    public double getSpeed()
    {
        return (getWeapon()).getSpeed()*2;
    }

    @Override
    public int getAmmountofUpgrades()
    {
        return (getWeapon()).getAmmountofUpgrades()+1;
    }
}
