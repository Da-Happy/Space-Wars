package space.wars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;


public class SpaceWars extends ApplicationAdapter {
	public static World world;
	Box2DDebugRenderer debugRenderer;
	OrthographicCamera camera = new OrthographicCamera();
	public static SpriteBatch batch;


	public void create() {
		debugRenderer = new Box2DDebugRenderer(true, true, false, false, true, false);
		camera.setToOrtho(false,120, 120);
		world = new World(new Vector2(0, 0), true);
		batch = new SpriteBatch();
	}

	public Vector2 normalize (float x, float y, float mul) {
		float toat = Math.abs(x)+Math.abs(y);
		x = x/toat*mul;
		y = y/toat*mul;
		return (new Vector2(x,y));
	}

	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		world.step(1/60f, 6, 2);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		batch.end();

		debugRenderer.render(world, camera.combined);

	}

	public void dispose () {
		world.dispose();
	}
}