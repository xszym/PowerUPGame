package com.xszym.powerup.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.xszym.powerup.PowerUPMain;

public abstract class AbstractScreen implements Screen {

    protected PowerUPMain game;
    protected Stage stage;
    protected OrthographicCamera camera;
    protected SpriteBatch spriteBatch;

    public AbstractScreen(PowerUPMain game) {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(PowerUPMain.WIDTH, PowerUPMain.HEIGHT, camera));


        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        init();
    }

    protected abstract void init();

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, PowerUPMain.WIDTH, PowerUPMain.HEIGHT);
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
