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
import schumiwilde.projects.HighScores;
import schumiwilde.projects.Orchestrator;

import java.util.Map;

public class HighScoreScreen implements Screen {
    private Orchestrator parent;
    private Texture backgroundTexture;
    private Sprite backgroundImage;
    private SpriteBatch spriteBatch;
    private Stage stage;

    private HighScores highScores = new HighScores();

    public HighScoreScreen(Orchestrator parent) {
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

        Label mainMenuLabel = new Label("Najwyzsze wyniki", skin);
        table.add(mainMenuLabel).colspan(2);
        table.row().pad(10, 0, 0, 10);

        for (Map.Entry<String, Integer> entry : highScores.getHighScores().entrySet()) {
            Label keyLabel = new Label(entry.getKey(), skin);
            Label valueLabel = new Label(entry.getValue().toString(), skin);
            table.add(keyLabel).left();
            table.add(valueLabel);
            table.row().pad(10, 0, 0, 10);
        }

        TextButton backButton = new TextButton("Wroc", skin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeGameScreen(Orchestrator.MENU_SCREEN);
            }
        });

        table.add(backButton).colspan(2);
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

    }
}
