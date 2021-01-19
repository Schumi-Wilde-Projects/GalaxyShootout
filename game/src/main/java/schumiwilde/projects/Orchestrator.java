package schumiwilde.projects;

import com.badlogic.gdx.Game;
import schumiwilde.projects.menu.*;
import schumiwilde.projects.menu.settings.GameSettings;

// Zmieniarka do widoków xDDD
public class Orchestrator extends Game {
    // Tymczasowe pseudo-stany
    public final static int MENU_SCREEN = 0;
    public final static int SETTINGS_SCREEN = 1;
    public final static int LOADING_SCREEN = 2;
    public final static int HIGH_SCORE_SCREEN = 3;
    public final static int GAME_SCREEN = 4;
    public final static int PAUSE_SCREEN = 5;
    public final static int GAME_OVER_SCREEN = 6; // Ekran końca gry
    public final static int END_GAME_SCREEN = 7; // Ekran wyjścia z gry (not to be confused lol)

    private MainMenuScreen mainMenuScreen;
    private LoadingScreen loadingScreen;
    private HighScoreScreen highScoreScreen;
    private SettingsScreen settingsScreen;
    private GameScreen gameScreen;
    private PauseScreen pauseScreen;
    private GameOverScreen gameOverScreen;
    private EndGameScreen endGameScreen;

    private GameSettings settings;

    @Override
    public void create() {
        loadingScreen = new LoadingScreen(this);
        settings = new GameSettings();
        setScreen(loadingScreen);
    }

    // TODO Zastąpić to później stanami
    public void changeGameScreen(int state) {
        switch (state) {
            case MENU_SCREEN:
                if (mainMenuScreen == null) {
                    mainMenuScreen = new MainMenuScreen(this);
                }
                this.setScreen(mainMenuScreen);
                break;
            case SETTINGS_SCREEN:
                if (settingsScreen == null) {
                    settingsScreen = new SettingsScreen(this);
                }
                this.setScreen(settingsScreen);
                break;
            case LOADING_SCREEN:
                if (loadingScreen == null) {
                    loadingScreen = new LoadingScreen(this);
                }
                this.setScreen(loadingScreen);
                break;
            case HIGH_SCORE_SCREEN:
                if (highScoreScreen == null) {
                    highScoreScreen = new HighScoreScreen(this);
                }
                this.setScreen(highScoreScreen);
                break;
            case GAME_SCREEN:
                if (gameScreen == null) {
                    gameScreen = new GameScreen(this);
                }
                this.setScreen(gameScreen);
                break;
            case PAUSE_SCREEN:
                if (pauseScreen == null) {
                    pauseScreen = new PauseScreen(this);
                }
                this.setScreen(pauseScreen);
                break;
            case GAME_OVER_SCREEN:
                if (gameOverScreen == null) {
                    gameOverScreen = new GameOverScreen(this);
                }
                this.setScreen(gameOverScreen);
                break;
            case END_GAME_SCREEN:
                if (endGameScreen == null) {
                    endGameScreen = new EndGameScreen(this);
                }
                this.setScreen(endGameScreen);
                break;
        }
    }

    public GameSettings getSettings() {
        return this.settings;
    }
}
