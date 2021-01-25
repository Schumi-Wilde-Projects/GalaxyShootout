package schumiwilde.projects.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
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

public class MainMenuScreen implements Screen {
    private Orchestrator parent;
    private Texture backgroundTexture;
    private Sprite backgroundImage;
    private SpriteBatch spriteBatch;
    private Stage stage;

    public MainMenuScreen(Orchestrator parent) {
        this.parent = parent;
        this.spriteBatch = new SpriteBatch();
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

        TextButton playButton = new TextButton("Graj", skin);
        TextButton settingsButton = new TextButton("Ustawienia", skin);
        TextButton highScoreButton = new TextButton("Najwyzsze wyniki", skin);
        TextButton exitButton = new TextButton("Wyjdz", skin);

        Label mainMenuLabel = new Label("Menu glowne", skin);
        table.add(mainMenuLabel).colspan(2);
        table.row().pad(10, 0, 0, 10);
        table.add(playButton).fill().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(settingsButton).fill().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(highScoreButton).fill().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(exitButton).fill().uniformX();
        table.row().pad(10, 0, 10, 0);

        Label versionNumberLabel = new Label("Wersja v0.6 beta", skin);
        stage.addActor(versionNumberLabel);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeGameScreen(Orchestrator.GAME_SCREEN);
            }
        });

        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeGameScreen(Orchestrator.SETTINGS_SCREEN);
            }
        });

        highScoreButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeGameScreen(Orchestrator.HIGH_SCORE_SCREEN);
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundTexture = new Texture("img/kosmos.jpg");
        backgroundImage = new Sprite(backgroundTexture);
        spriteBatch.begin();
        backgroundImage.draw(spriteBatch);
        spriteBatch.end();
        backgroundTexture.dispose();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 20f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }
}
