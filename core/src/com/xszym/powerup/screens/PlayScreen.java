package com.xszym.powerup.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;
import com.xszym.powerup.PowerUPMain;
import com.xszym.powerup.entitlies.Platform;
import com.xszym.powerup.entitlies.Robot;

import com.badlogic.gdx.utils.Array;

import java.util.Random;


public class PlayScreen extends AbstractScreen {

    private Image bgGame;
    private Array<Robot> robots;
    private Array<Platform> platforms;

    private int countOfRobots;

    public PlayScreen(PowerUPMain game) {
        super(game);
    }

    @Override
    protected void init() {
        initBG();
        initRobots();
        createRobots();

        initPlatforms();

        countOfRobots = 3;

        Timer.schedule(new Timer.Task(){
                           @Override
                           public void run() {
                               countOfRobots++;
                           }
                       }
                , 1        //    (delay)
                , new Random().nextInt(2) + 1     //    (seconds)
        );


    }

    private void initPlatforms() {
        platforms = new Array<Platform>();

        for (int i = 1; i <= 5; i++) {
            platforms.add(new Platform(i * (Platform.PLATFORM_HEIGHT) + 50 ));
            stage.addActor(platforms.get(i - 1));
        }
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

        int robotsSize = robots.size;

        if(robotsSize < countOfRobots){
           robots.add(new Robot((Robot.HEIGHT)));
            stage.addActor(robots.get(robots.size - 1));
            robots.get(robotsSize).fly(new Random().nextInt(500), 30);
        }


        Gdx.app.log("count of Robots", "Count of robots: " + robotsSize );
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
                    boolean b = robots.removeValue(robot, false);
                    //Gdx.app.log("wartosc", b);
                    robot.remove();
                    countOfRobots--;
                    return false;
                }
            });



            robot.updateRobot(delta);

        }
    }

}
