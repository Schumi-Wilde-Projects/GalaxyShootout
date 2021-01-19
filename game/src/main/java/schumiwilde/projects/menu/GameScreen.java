package schumiwilde.projects.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
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
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import schumiwilde.projects.Orchestrator;
import schumiwilde.projects.controller.KeyboardControl;
import schumiwilde.projects.player.Player;

public class GameScreen implements Screen {
    private Orchestrator parent;
    private OrthographicCamera camera;
    private KeyboardControl keyboardControl;
    private Stage stage;
    private ShapeRenderer shapeRenderer;
    private InputMultiplexer inputMultiplexer;

    private Texture backgroundTexture;
    private Sprite backgroundImage;
    private Table healthTable;
    private Player playerShip;
    private final SpriteBatch spriteBatch;
    private final int randomPicture = (int) Math.floor(Math.random() * 3) + 1;

    // Tymczasowe zmienne!
    private int userScore = 0;

    public GameScreen(Orchestrator parent) {
        this.parent = parent;
        keyboardControl = new KeyboardControl();
        stage = new Stage(new ScreenViewport());
        shapeRenderer = new ShapeRenderer();
        this.spriteBatch = new SpriteBatch();
        this.inputMultiplexer = new InputMultiplexer(stage, keyboardControl);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputMultiplexer);
        stage.clear();

        Skin skin = new Skin(Gdx.files.internal("star-soldier/skin/star-soldier-ui.json"));

        playerShip = Player.getInstance().reset();

        if(parent.getSettings().isRtxEnabled())
            playerShip.setRtxOn();

        playerShip.setPosition(Gdx.graphics.getWidth() / 2f - 50,
                50);

//        Label livesLeftLabel = new Label("Zycia: " + livesLeft, skin);
//        livesLeftLabel.setPosition(0,Gdx.graphics.getHeight() - 20);
//        livesLeftLabel.setAlignment(Align.topLeft);
        Label scoreLabel = new Label("Wynik: " + userScore, skin);
        scoreLabel.setPosition(Gdx.graphics.getWidth() - 110,Gdx.graphics.getHeight() - 20);
        scoreLabel.setAlignment(Align.topRight);
        Label currentWeaponLabel = new Label("Bron: ", skin);

        healthTable = new Table();
        healthTable.setFillParent(true);
        for (int i = 0; i < playerShip.getHP(); i++) {
            if (parent.getSettings().isRtxEnabled()) {
                Texture heartTexture = new Texture("img/rtxon/heart.png");
                Image heartImage = new Image(heartTexture);
                healthTable.add(heartImage).width(40).height(40);
            } else {
                Texture heartTexture = new Texture("img/rtxoff/full_heart.png");
                Image heartImage = new Image(heartTexture);
                healthTable.add(heartImage).width(40).height(40);
            }
        }

        stage.addActor(scoreLabel);
        stage.addActor(healthTable.top().left());
        stage.addActor(currentWeaponLabel);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (keyboardControl.escapePressed) {
            parent.changeGameScreen(Orchestrator.PAUSE_SCREEN);
        }
        if(keyboardControl.leftPressed && playerShip.getX() > 0) {
            playerShip.move(-5);
        }
        if(keyboardControl.rightPressed && playerShip.getX() < Gdx.graphics.getWidth() - 100) {
            playerShip.move(5);
        }

        backgroundTexture = new Texture("img/game_cosmos" + randomPicture + ".jpg");
        backgroundImage = new Sprite(backgroundTexture);
        spriteBatch.begin();
        backgroundImage.draw(spriteBatch);
        spriteBatch.draw(playerShip, playerShip.getX(), playerShip.getY(), 100, 100);
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
    public void dispose()
    {
        shapeRenderer.dispose();
        spriteBatch.dispose();
    }
}
