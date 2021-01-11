package schumiwilde.projects.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import schumiwilde.projects.Orchestrator;

public class SettingsScreen implements Screen {
    private Orchestrator parent;
    private Texture backgroundTexture;
    private Sprite backgroundImage;
    private SpriteBatch spriteBatch;
    private Stage stage;

    public SettingsScreen(Orchestrator parent) {
        this.parent = parent;
        this.spriteBatch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
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

        final Slider volumeSfxSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeSfxSlider.setValue(parent.getSettings().getSoundVolume());
        volumeSfxSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getSettings().setSoundVolume(volumeSfxSlider.getValue());
                return false;
            }
        });

        final CheckBox sfxCheckbox = new CheckBox(null, skin);
        sfxCheckbox.setChecked(parent.getSettings().isSoundEnabled());
        sfxCheckbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = sfxCheckbox.isChecked();
                parent.getSettings().setSoundEnabled(enabled);
                return false;
            }
        });

        final CheckBox rtxCheckbox = new CheckBox(null, skin);
        rtxCheckbox.setChecked(parent.getSettings().isRtxEnabled());
        rtxCheckbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = rtxCheckbox.isChecked();
                parent.getSettings().setRtxEnabled(enabled);
                return false;
            }
        });

        TextButton backButton = new TextButton("Wroc", skin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                parent.changeGameScreen(Orchestrator.MENU_SCREEN);
            }
        });

        Label settingsLabel = new Label("Ustawienia", skin);
        Label volumeSfxLabel = new Label("Glosnosc", skin);
        Label sfxToggleLabel = new Label("Dzwiek", skin);
        Label rtxOnOffLabel = new Label("RTX ON", skin);

        table.add(settingsLabel).colspan(2);
        table.row().pad(10, 0, 0, 10);
        table.add(sfxToggleLabel).left();
        table.add(sfxCheckbox);
        table.row().pad(10, 0, 0, 10);
        table.add(volumeSfxLabel).left();
        table.add(volumeSfxSlider);
        table.row().pad(10, 0, 0, 10);
        table.add(rtxOnOffLabel).left();
        table.add(rtxCheckbox);
        table.row().pad(10, 0, 0, 10);
        table.add(backButton).colspan(2);

        Label versionNumberLabel = new Label("Autorzy: Michal Bogusz, Patryk Kaczor, Kamil Kundzicz", skin);
        stage.addActor(versionNumberLabel);
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
