package schumiwilde.projects.Weapons;

public class AmountOfBulletsUpgrade extends WeaponUpgrade
{
    public AmountOfBulletsUpgrade(Weapons weapon)
    {
        super(weapon);
    }

    @Override
    public int getAmountofBullets()
    {
        return (getWeapon()).getAmountofBullets()*2;
    }
    @Override
    public int getAmmountofUpgrades()
    {
        return (getWeapon()).getAmmountofUpgrades()+1;
    }
}
