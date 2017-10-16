package com.xszym.powerup.entitlies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.xszym.powerup.PowerUPMain;

import java.util.Random;


public class Platform extends Image {
    public final static int PLATFORM_WIDHT = 60;
    public final static int PLATFORM_HEIGHT = 20;


    private static final int FLUCTUATION = PowerUPMain.WIDTH - PLATFORM_WIDHT;

    private Random rand;

    private Rectangle boundsPlatform;

    public Platform(float y) {
        super(new Texture("badlogic.jpg"));

        this.setOrigin(PLATFORM_WIDHT / 2, PLATFORM_HEIGHT / 2);
        this.setSize(PLATFORM_WIDHT, PLATFORM_HEIGHT);
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
