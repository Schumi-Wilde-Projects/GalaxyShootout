package schumiwilde.projects.Weapons;

public enum WeaponType {
    BASIC_WEAPON(new BasicWeapon()),
    PLASMA_WEAPON(new PlasmaWeapon()),
    ROCKET_WEAPON(new RocketWeapon());

    Weapons weapon;

    WeaponType(Weapons weapon) {
        this.weapon = weapon;
    }

    public Weapons getWeapon() {
        return weapon;
    }
}
