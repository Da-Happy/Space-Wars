package space.wars.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import space.wars.SpaceWars;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Spaceship Game";
		config.width = 240;
		config.height = 240;
		new LwjglApplication(new SpaceWars(), config);
	}
}
