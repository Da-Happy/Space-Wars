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
	public SpaceShip ship;

	public void create() {
		debugRenderer = new Box2DDebugRenderer(true, true, false, false, true, false);
		camera.setToOrtho(false,240, 240);
		world = new World(new Vector2(0, 0), true);
		batch = new SpriteBatch();

		ship = new SpaceShip(60*2,60*2);

	}

	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		world.step(1/60f, 6, 2);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		Gun.shoot(ship);
		batch.end();

		debugRenderer.render(world, camera.combined);

	}

	public void dispose () {
		world.dispose();
	}
}