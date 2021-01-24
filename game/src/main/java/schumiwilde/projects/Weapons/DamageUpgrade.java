package schumiwilde.projects.Weapons;

public class DamageUpgrade extends WeaponUpgrade
{
    public DamageUpgrade(Weapons weapon)
    {
        super(weapon);
    }
    @Override
    public int getDamage()
    {
        return (getWeapon()).getDamage()*2;
    }
    @Override
    public int getAmmountofUpgrades()
    {
        return (getWeapon()).getAmmountofUpgrades()+1;
    }
}
