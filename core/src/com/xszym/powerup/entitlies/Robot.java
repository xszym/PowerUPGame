package com.xszym.powerup.entitlies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.xszym.powerup.PowerUPMain;



import java.util.Random;

public class Robot extends Image
{
    public final static int WIDHT = 50 ;
    public final static int HEIGHT = 50;

    public final static int STARTING_X = 100;
    public final static int STARTING_Y = 100;

    private static final int GRAVITY = -10;

    private static final int FLUCTUATION = PowerUPMain.WIDTH - WIDHT;

    private Vector3 position;
    private Vector3 velocity;

    public boolean maxRight;
    public boolean maxLeft;

    private Random rand;

    private Rectangle boundsPlayer;

    public Robot(float y){
       super(new Texture("badlogic.jpg"));

        rand = new Random();

        boundsPlayer = new Rectangle(this.getX() + 10, this.getY(), this.getWidth(), this.getHeight());

        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);

        //start position

        this.setPosition(rand.nextInt(FLUCTUATION), y);

        initVectors(y);

    }

    private void initVectors(float y) {
        position = new Vector3(y , y, 0);
        velocity = new Vector3(0, 0, 0);
    }
    public void updateRobot(float delta) {

        this.setPosition(position.x, position.y);
        velocity.add(0, GRAVITY, 0);
        velocity.scl(delta);
        position.add(velocity.x, velocity.y, 50);
        if (position.y < 0) {
            position.y = 0;
        }

        if (position.x < 0){
            position.x = 0;
            maxLeft = true;
        } else {
            maxLeft = false;
        }
        if (position.x > PowerUPMain.WIDTH - WIDHT){
            position.x = PowerUPMain.WIDTH - WIDHT;
            maxRight = true;
        } else {
            maxRight = false;
        }
        velocity.scl(1 / delta);

        boundsPlayer.setPosition(position.x, position.y);

        if(maxLeft){
            this.fly(+50, 40);
        }
        if (maxRight){
            this.fly(-50, 40);
        }
    }

    public void fly(int x, int y) {
        velocity.x = x;
        velocity.y = y;
    }

    public Rectangle getBoundsPlayer(){
        return boundsPlayer;
    }


    public void reposition(float y) {

        this.setPosition(rand.nextInt(FLUCTUATION), y);
        boundsPlayer.setPosition(this.getX(), this.getY());

    }


    public boolean collides(Rectangle platfom) {

        return platfom.overlaps(boundsPlayer);
    }


}