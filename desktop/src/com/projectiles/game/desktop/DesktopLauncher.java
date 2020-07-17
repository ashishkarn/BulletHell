package com.projectiles.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.projectiles.game.GdxGameClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Projectiles";
		cfg.useGL30 = false;
		cfg.width = 800;
		cfg.height = 480;
		cfg.fullscreen = false;
		new LwjglApplication(new GdxGameClass(), cfg);
	}
}
