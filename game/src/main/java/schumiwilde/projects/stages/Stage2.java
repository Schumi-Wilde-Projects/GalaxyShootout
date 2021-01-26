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
        return builder.init().addAggressiveShip(WeaponType.ROCKET_WEAPON, 15, 400, 400)
                .addDefensiveShip(WeaponType.BASIC_WEAPON, 15, 350, 400)
                .addSuicideShip(WeaponType.BASIC_WEAPON, 15, 300, 400, 150, 50)
                .addDefensiveShip(WeaponType.BASIC_WEAPON, 15, 250, 400)
                .addAggressiveShip(WeaponType.ROCKET_WEAPON, 15, 200, 400)
                .finish();
    }
}
