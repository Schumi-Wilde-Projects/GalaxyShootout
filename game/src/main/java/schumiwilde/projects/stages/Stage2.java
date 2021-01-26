package schumiwilde.projects.stages;

import schumiwilde.projects.Weapons.WeaponType;

public class Stage2 implements StageFacade {

    private final boolean isRtxOn;

    public Stage2(boolean isRtxOn) {
        this.isRtxOn = isRtxOn;
    }

    @Override
    public Stage buildStage() {
        StageBuilder builder = new StageBuilder(isRtxOn);
        return builder.init().addAggressiveShip(WeaponType.ROCKET_WEAPON, 15, 250, 600)
                .addDefensiveShip(WeaponType.BASIC_WEAPON, 15, 200, 600)
                .addSuicideShip(WeaponType.BASIC_WEAPON, 15, 150, 600)
                .addDefensiveShip(WeaponType.BASIC_WEAPON, 15, 100, 600)
                .addAggressiveShip(WeaponType.ROCKET_WEAPON, 15, 50, 600)
                .finish();
    }
}
