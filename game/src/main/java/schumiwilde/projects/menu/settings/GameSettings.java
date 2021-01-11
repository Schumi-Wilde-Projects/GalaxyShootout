package schumiwilde.projects.menu.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GameSettings {
    private static final String SETTING_SFX_VOLUME = "sound";
    private static final String SETTING_SFX_ENABLED = "sound.enabled";
    private static final String SETTING_RTX_ENABLED = "rtx";
    private static final String SETTINGS_NAME = "settings";

    protected Preferences getSettings() {
        return Gdx.app.getPreferences(SETTINGS_NAME);
    }

    public boolean isSoundEnabled() {
        return getSettings().getBoolean(SETTING_SFX_ENABLED, true);
    }

    public void setSoundEnabled(boolean soundEnabled) {
        getSettings().putBoolean(SETTING_SFX_ENABLED, soundEnabled);
        getSettings().flush();
    }

    public float getSoundVolume() {
        return getSettings().getFloat(SETTING_SFX_VOLUME, 0.5f);
    }

    public void setSoundVolume(float soundVolume) {
        getSettings().putFloat(SETTING_SFX_VOLUME, soundVolume);
        getSettings().flush();
    }

    public boolean isRtxEnabled() {
        return getSettings().getBoolean(SETTING_RTX_ENABLED, true);
    }

    public void setRtxEnabled(boolean rtxEnabled) {
        getSettings().putBoolean(SETTING_RTX_ENABLED, rtxEnabled);
        getSettings().flush();
    }
}
