package schumiwilde.projects.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import schumiwilde.projects.Orchestrator;

import java.util.Map;

public class PauseScreen implements Screen {
    private Orchestrator parent;
//    private Texture backgroundTexture;
//    private Sprite backgroundImage;
//    private SpriteBatch spriteBatch;
    private Stage stage;

    public PauseScreen(Orchestrator parent) {
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();
        Skin skin = new Skin(Gdx.files.internal("star-soldier/skin/star-soldier-ui.json"));

        Label titleLabel = new Label("Galaxy Shootout", skin, "title");
        titleLabel.setPosition(0,Gdx.graphics.getHeight() - 100 * 2);
        titleLabel.setSize(Gdx.graphics.getWidth(), 200);
        titleLabel.setAlignment(Align.center);
        stage.addActor(titleLabel);

        Table table = new Table();
        table.setFillParent(true);
//        table.setDebug(true);
        stage.addActor(table);

        Label mainMenuLabel = new Label("Pauza", skin);
        table.add(mainMenuLabel).colspan(2);
        table.row().pad(10, 0, 0, 10);

        TextButton playButton = new TextButton("Wznow", skin);
        TextButton exitButton = new TextButton("Wyjdz", skin);

        table.row().pad(10, 0, 0, 10);
        table.add(playButton).fill().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(exitButton).fill().uniformX();

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeGameScreen(Orchestrator.GAME_SCREEN);
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeGameScreen(Orchestrator.MENU_SCREEN);
            }
        });
    }

    @Override
    public void render(float v) {

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
