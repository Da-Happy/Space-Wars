package space.wars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Math.round;


public class SpaceWars extends ApplicationAdapter {
	public static World world;
	Box2DDebugRenderer debugRenderer;
	OrthographicCamera camera = new OrthographicCamera();
	public static SpriteBatch batch;
	public SpaceShip ship;
	public SpaceShip ship2;
	public static int overheat;
	public static int overheat2;
	public static inputs test;


	public void create() {
		test = new inputs();
		debugRenderer = new Box2DDebugRenderer(true, true, false, false, true, false);
		camera.setToOrtho(true,500, 500);
		world = new World(new Vector2(0, 0), true);
		batch = new SpriteBatch();
		int centerX = round(camera.viewportWidth/2);
		int centerY = round(camera.viewportHeight/2);
		ship = new SpaceShip(centerX-centerX/2,centerY, true);
		ship2 = new SpaceShip(centerX+centerX/2, centerY, false);
	}

	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		world.step(1/60f, 6, 2);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		ship.render();
		ship2.render();
		batch.end();
		if(overheat > 0){
			overheat = overheat-1;
		}
		if(overheat2 > 0){
			overheat2 = overheat2-1;
		}
		debugRenderer.render(world, camera.combined);

	}

	public void dispose () {
		world.dispose();
	}
}