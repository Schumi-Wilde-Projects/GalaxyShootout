package schumiwilde.projects.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import schumiwilde.projects.Orchestrator;

public class LoadingScreen implements Screen {
    private Orchestrator parent;

    public LoadingScreen(Orchestrator parent) {
        this.parent = parent;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        parent.changeGameScreen(Orchestrator.MENU_SCREEN);
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
