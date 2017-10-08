package com.xszym.powerup.entitlies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.xszym.powerup.PowerUPMain;

import java.util.Random;


public class Platform extends Image {
    public final static int TUBE_WIDHT = 200;
    public final static int TUBE_HEIGHT = 142;


    private static final int FLUCTUATION = PowerUPMain.WIDTH - TUBE_WIDHT;
    private static final int GEARS_GAP = 100;
    private static final int LOWEST_OPENING = 00;

    private Random rand;

    private Rectangle boundsPlatform;

    public Platform(float y) {
        super(new Texture("badlogic.jpg"));

        this.setOrigin(TUBE_WIDHT / 2, TUBE_HEIGHT / 2);
        this.setSize(TUBE_WIDHT, TUBE_HEIGHT);
        rand = new Random();

        this.setPosition(rand.nextInt(FLUCTUATION), y);

        boundsPlatform = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        this.setDebug(true);
    }

    public void reposition(float y) {

        this.setPosition(rand.nextInt(FLUCTUATION), y);
        boundsPlatform.setPosition(this.getX(), this.getY());

    }

    public boolean collides(Rectangle robot) {

        return robot.overlaps(boundsPlatform);
    }

}
