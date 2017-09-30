package com.xszym.powerup.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.xszym.powerup.PowerUPMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();;
		config.title = PowerUPMain.TITLE;
		config.width = PowerUPMain.WIDTH;
		config.height = PowerUPMain.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new PowerUPMain(), config);
	}
}
