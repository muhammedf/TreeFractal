package sunofkyuss.treefractal.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import sunofkyuss.treefractal.core.TreeFractalRenderer;

public class TreeFractalRendererDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new TreeFractalRenderer(), config);
	}
}
