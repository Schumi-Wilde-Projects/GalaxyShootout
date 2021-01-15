package schumiwilde.projects.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import schumiwilde.projects.Orchestrator;
import schumiwilde.projects.controller.KeyboardControl;

import java.util.ArrayList;

public class GameScreen implements Screen {
    private Orchestrator parent;
    private OrthographicCamera camera;
    private KeyboardControl keyboardControl;
    private Stage stage;
    private ShapeRenderer shapeRenderer;

    private Texture backgroundTexture;
    private Sprite backgroundImage;
    private final SpriteBatch spriteBatch;
    private final int randomPicture = (int) Math.floor(Math.random() * 3) + 1;

    // Tymczasowe zmienne!
    private int userScore = 0;
    private int livesLeft = 3;

    public GameScreen(Orchestrator parent) {
        this.parent = parent;
        keyboardControl = new KeyboardControl();
        stage = new Stage(new ScreenViewport());
        shapeRenderer = new ShapeRenderer();
        this.spriteBatch = new SpriteBatch();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(keyboardControl);
        stage.clear();

        Skin skin = new Skin(Gdx.files.internal("star-soldier/skin/star-soldier-ui.json"));

//        Label livesLeftLabel = new Label("Zycia: " + livesLeft, skin);
//        livesLeftLabel.setPosition(0,Gdx.graphics.getHeight() - 20);
//        livesLeftLabel.setAlignment(Align.topLeft);
        Label scoreLabel = new Label("Wynik: " + userScore, skin);
        scoreLabel.setPosition(Gdx.graphics.getWidth() - 110,Gdx.graphics.getHeight() - 20);
        scoreLabel.setAlignment(Align.topRight);
        Label currentWeaponLabel = new Label("Bron: ", skin);

        Table healthTable = new Table();
        for (int i = 0; i < 3; i++) {
            if (parent.getSettings().isRtxEnabled()) {
                Texture heartTexture = new Texture("img/rtxon/heart.png");
                Sprite heartSprite = new Sprite(heartTexture);
                heartSprite.setSize(40, 40);
                Image image = new Image(new SpriteDrawable(heartSprite));
                healthTable.add(image);
                heartTexture.dispose();
            } else {
                Texture heartTexture = new Texture("img/rtxoff/heart.png");
                Sprite heartSprite = new Sprite(heartTexture);
                heartSprite.setSize(40, 40);
                Image image = new Image(new SpriteDrawable(heartSprite));
                healthTable.add(image);
                heartTexture.dispose();
            }
        }

        healthTable.setPosition(Gdx.graphics.getWidth() - 110,Gdx.graphics.getHeight() - 20);

        stage.addActor(scoreLabel);
        stage.addActor(healthTable);
        stage.addActor(currentWeaponLabel);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundTexture = new Texture("img/game_cosmos" + randomPicture + ".jpg");
        backgroundImage = new Sprite(backgroundTexture);
        spriteBatch.begin();
        backgroundImage.draw(spriteBatch);
        spriteBatch.end();
        backgroundTexture.dispose();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(keyboardControl);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
