package schumiwilde.projects.stages;

import schumiwilde.projects.EnemyShips.*;
import schumiwilde.projects.Weapons.WeaponType;

public class StageBuilder {

    private Stage stage;
    private final boolean isRtxOn;

    public StageBuilder(boolean isRtxOn) {
        this.isRtxOn = isRtxOn;
    }

    public StageBuilder init() {
        stage = new Stage();
        return this;
    }

    public StageBuilder addAggressiveShip(WeaponType weapon, int hp, float x, float y) {
        EnemyShip newEnemy = new AggressiveShip(isRtxOn, hp, weapon.getWeapon());
        newEnemy.setXY(x, y);
        stage.spawnEnemy(newEnemy);
        return this;
    }

    public StageBuilder addDefensiveShip(WeaponType weapon, int hp, float x, float y) {
        EnemyShip newEnemy = new DefensiveShip(isRtxOn, hp, weapon.getWeapon());
        newEnemy.setXY(x, y);
        stage.spawnEnemy(newEnemy);
        return this;
    }

    public StageBuilder addSuicideShip(WeaponType weapon, int hp, float x, float y) {
        EnemyShip newEnemy = new SuicideShip(isRtxOn, hp, weapon.getWeapon());
        newEnemy.setXY(x, y);
        stage.spawnEnemy(newEnemy);
        return this;
    }

    public Stage finish() {
        return stage;
    }
}
