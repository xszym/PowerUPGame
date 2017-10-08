package com.xszym.powerup.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.xszym.powerup.PowerUPMain;
import com.xszym.powerup.entitlies.Robot;

import com.badlogic.gdx.utils.Array;

import java.util.Random;


public class PlayScreen extends AbstractScreen {

    private Image bgGame;
    private Array<Robot> robots;

    public PlayScreen(PowerUPMain game) {
        super(game);
    }

    @Override
    protected void init() {
        initBG();
        initRobots();
        createRobots();
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

        checkRobotTouched(delta);

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


    private void initRobots() {

        robots = new Array<Robot>();

        for (int i = 1; i <= 5; i++) {
            robots.add(new Robot(i * (Robot.HEIGHT)));
            stage.addActor(robots.get(i - 1));
        }
    }

    private void createRobots() {

        for (final Robot robot : robots) {
            Random random = new Random();

            robot.fly(random.nextInt() * 10,100);

        }
    }

    private void checkRobotTouched(float delta) {
        for (final Robot robot : robots) {

            robot.addListener(new InputListener() {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    //Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                    robot.remove();
                    return false;
                }
            });

            robot.updateRobot(delta);

        }
    }

}
