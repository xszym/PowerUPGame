package com.xszym.powerup.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.xszym.powerup.PowerUPMain;

public class PlayScreen extends AbstractScreen {

    private Image bgGame;

    public PlayScreen(PowerUPMain game) {
        super(game);
    }

    @Override
    protected void init() {
        initBG();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        update(delta);

        drawStage();
    }

    private void update(float delta) {

        bgGame.setPosition(0, camera.position.y - (camera.viewportHeight / 2));


        camera.update();
    }

    @Override
    public void resize(int width, int height) {

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

    private void drawStage() {
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }


    private void initBG() {
        bgGame = new Image(new Texture("bg.jpg"));
        bgGame.setX(0);
        bgGame.setY(0);
        bgGame.setHeight(PowerUPMain.HEIGHT);
        bgGame.setWidth(PowerUPMain.WIDTH);
        stage.addActor(bgGame);
    }
}
