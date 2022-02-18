package space.wars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

import static java.lang.Math.round;


public class SpaceWars extends ApplicationAdapter {
	public static World world;
	Box2DDebugRenderer debugRenderer;
	OrthographicCamera camera = new OrthographicCamera();
	private SpriteBatch batch;
	private Texture red;
	public SpaceShip ship;
	public SpaceShip ship2;
	public int ConstantOfGravity = 20;
	public static int overheat;
	public static int overheat2;
	public static ArrayList<Body> queue;
	public void create() {
		queue = new ArrayList<>();
		debugRenderer = new Box2DDebugRenderer(true, true, false, false, true, false);
		camera.setToOrtho(true,500, 500);
		world = new World(new Vector2(0, 0), true);
		world.setContactListener(new CollisionListener());
		batch = new SpriteBatch();
		red = new Texture("red.gif");
		int centerX = round(camera.viewportWidth/2);
		int centerY = round(camera.viewportHeight/2);
		ship = new SpaceShip(centerX+centerX/2,centerY);
		ship2 = new SpaceShip(centerX-centerX/2, centerY);
	}

	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		world.step(1/60f, 6, 2);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(red, ship.body.getPosition().x, ship.body.getPosition().y,ship.body.getPosition().x,ship.body.getPosition().y,red.getWidth(),red.getHeight(),2,2,ship.body.getAngle(),0,0,32,32,false,true);
		batch.end();
		fixedgunlol.shewt(ship,true);
		moveit.move(ship,true);
		fixedgunlol.shewt(ship2,false);
		moveit.move(ship2,false);
		if(overheat > 0){
			overheat = overheat-1;
		}
		if(overheat2 > 0){
			overheat2 = overheat2-1;
		}
		for (int i = 0; i < queue.size(); i++) {
			world.destroyBody(queue.get(i));
		}
		queue.clear();
		if(ship.health <= 0){
			queue.add(ship.body);
			ship.health = 100;
		}
		if(ship2.health <= 0){
			queue.add(ship2.body);
			ship2.health = 100;
		}
		debugRenderer.render(world, camera.combined);
	}

	public void dispose () {

		world.dispose();
		batch.dispose();
	}
}