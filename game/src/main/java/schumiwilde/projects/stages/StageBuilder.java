package schumiwilde.projects.stages;

import schumiwilde.projects.EnemyShips.AggressiveShip;
import schumiwilde.projects.EnemyShips.DefensiveShip;
import schumiwilde.projects.EnemyShips.EnemyShip;
import schumiwilde.projects.EnemyShips.SuicideShip;
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
        newEnemy.setPosition(x, y);
        stage.spawnEnemy(newEnemy);
        return this;
    }

    public StageBuilder addDefensiveShip(WeaponType weapon, int hp, float x, float y) {
        EnemyShip newEnemy = new DefensiveShip(isRtxOn, hp, weapon.getWeapon());
        newEnemy.setPosition(x, y);
        stage.spawnEnemy(newEnemy);
        return this;
    }

    public StageBuilder addSuicideShip(WeaponType weapon, int hp, float x, float y, float targetX, float targetY) {
        EnemyShip newEnemy = new SuicideShip(isRtxOn, hp, weapon.getWeapon());
        newEnemy.setPosition(x, y);
        newEnemy.setXY(targetX, targetY);
        stage.spawnEnemy(newEnemy);
        return this;
    }

    public Stage finish() {
        return stage;
    }
}
