package sunofkyuss.treefractal.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import sunofkyuss.treefractal.drawer.Drawer;
import sunofkyuss.treefractal.drawer.LibgdxDrawer;
import sunofkyuss.treefractal.fractaltree.TreeFractalBuilder;
import sunofkyuss.treefractal.util.Vector2D;

public class TreeFractalRenderer extends InputAdapter implements ApplicationListener {
	private float elapsed;
	private ShapeRenderer sr;
	private float angle;
	private boolean render;
	private float angleAcc;
	private float depthLength;
	private float depthLengthAcc;
	private long seed;
	private Drawer drawer;

	@Override
	public void create() {
		Gdx.graphics.setDisplayMode(1500, 1000, false);
		sr = new ShapeRenderer();
		Gdx.input.setInputProcessor(this);
		angle = 0;
		render = true;
		angleAcc = 0.5f;
		seed = System.currentTimeMillis();
		depthLength = 0;
		depthLengthAcc = 2;
		drawer=new LibgdxDrawer(sr);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {
		

		if (Gdx.input.isKeyPressed(Keys.W)) {
			angle += angleAcc;
			render = true;
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			angle -= angleAcc;
			render = true;
		}
		if (Gdx.input.isKeyPressed(Keys.O)) {
			depthLength += depthLengthAcc;
			render = true;
		}
		if (Gdx.input.isKeyPressed(Keys.K)) {
			depthLength -= depthLengthAcc;
			render = true;
		}

		if (depthLength < 0) {
			depthLength = 0;
		}
//		depthLengthAcc = 1 / ((depthLength+30)) * 3000;

		if (render) {
			elapsed += Gdx.graphics.getDeltaTime();
			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

			sr.begin(ShapeType.Line);

			TreeFractalBuilder.getNewInstance()
					.setFirstAngle(90)
					.setFirstLength(100)
					.setStartPoint(new Vector2D(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 4))
					.setAngleChangeFunctionLine1(a -> a + angle)
					.setAngleChangeFunctionLine2(a -> a - angle/5)
					.setLengthChangeFunctionLine1(a -> a * 6 / 10)
					.setLengthChangeFunctionLine2(a -> a * 9 / 10)
					.setFirstSeed(seed)
					.setEndCondition((length, depth) -> length < 2 || depth > 150)
					.setDepthLength(depthLength)
					.build()
					.draw(drawer);

			sr.end();

			render = false;
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.C) {
			seed = System.currentTimeMillis();
		}
		render = true;
		return false;
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
