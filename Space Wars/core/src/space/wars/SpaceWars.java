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

	public void create() {
		debugRenderer = new Box2DDebugRenderer(true, true, false, false, true, false);
		camera.setToOrtho(true,1000, 1000);
		world = new World(new Vector2(0, 0), true);
		batch = new SpriteBatch();
		int centerX = round(camera.viewportWidth/2);
		int centerY = round(camera.viewportHeight/2);
		ship = new SpaceShip(centerX+200,centerY);
		ship2 = new SpaceShip(centerX-200, centerY);
	}

	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		world.step(1/60f, 6, 2);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		fixedgunlol.shewt(ship,true);
		moveit.move(ship,true);
		fixedgunlol.shewt(ship2,false);
		moveit.move(ship2,false);
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