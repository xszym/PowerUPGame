package com.xszym.powerup;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.xszym.powerup.screens.PlayScreen;

public class PowerUPMain extends Game {


	public static final int WIDTH = 270;
	public static final int HEIGHT = 480;
	public static final String TITLE = "PowerUP FRC 2018";
	public static final boolean setDebug = false;

	private boolean paused;

	public static Image bg;

	@Override
	public void create () {

		initBG();

		this.setScreen(new PlayScreen(this));

	}
	

	public void initBG() {

		bg = new Image(new Texture("bg.jpg"));
		PowerUPMain.bg.setX(0);
		PowerUPMain.bg.setY(0);
		PowerUPMain.bg.setHeight(PowerUPMain.HEIGHT);
		PowerUPMain.bg.setWidth(PowerUPMain.WIDTH);

	}

	//
	// getters and setters
	//

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
