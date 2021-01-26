package schumiwilde.projects.stages;

import schumiwilde.projects.Weapons.WeaponType;

public class Stage1 implements StageFacade {

    private final boolean isRtxOn;

    public Stage1(boolean isRtxOn) {
        this.isRtxOn = isRtxOn;
    }

    @Override
    public Stage buildStage() {
        StageBuilder builder = new StageBuilder(isRtxOn);
        return builder.init().addAggressiveShip(WeaponType.BASIC_WEAPON, 10, 200, 600)
                .addAggressiveShip(WeaponType.BASIC_WEAPON, 10, 250, 600)
                .addDefensiveShip(WeaponType.BASIC_WEAPON, 10, 150, 600)
                .addDefensiveShip(WeaponType.BASIC_WEAPON, 10, 100, 600)
                .finish();
    }
}
