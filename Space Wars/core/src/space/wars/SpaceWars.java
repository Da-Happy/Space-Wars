package space.wars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import org.w3c.dom.Text;
import sun.jvm.hotspot.gc.shared.Space;

import java.util.ArrayList;

import static java.lang.Math.round;


public class SpaceWars extends ApplicationAdapter {
	public static World world;
	Box2DDebugRenderer debugRenderer;
	OrthographicCamera camera = new OrthographicCamera();
	private SpriteBatch batch;
	private Texture red;
	private Texture blue;
	private Texture buleet;
	public SpaceShip ship;
	public SpaceShip ship2;
	public int ConstantOfGravity = 20;
	public static int overheat;
	public static int overheat2;
	public static ArrayList<Body> queue;
	public static ArrayList<Bullet> bullets = new ArrayList<>();
	public void create() {
		queue = new ArrayList<>();
		debugRenderer = new Box2DDebugRenderer(true, true, false, false, false, false);
		camera.setToOrtho(true,800, 500);
		world = new World(new Vector2(0, 0), true);
		world.setContactListener(new CollisionListener());
		batch = new SpriteBatch();
		red = new Texture("red.png");
		blue = new Texture("blue.png");
		buleet = new Texture("bulleet1.png");
		int centerX = round(camera.viewportWidth/2);
		int centerY = round(camera.viewportHeight/2);
		ship = new SpaceShip(centerX+centerX/2,centerY);
		ship2 = new SpaceShip(centerX-centerX/2, centerY);
	}

	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		world.step(1/60f, 6, 2);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if(ship.health < 99) {
			batch.draw(red, ship.body.getPosition().x - 8, ship.body.getPosition().y - 8, red.getWidth() / 2, red.getHeight() / 2, red.getWidth() * 2, red.getHeight() * 2, 1, 1, ship.body.getAngle() * MathUtils.radiansToDegrees, 0, 0, 32, 32, false, true);
		}
		if(ship2.health < 99) {
			batch.draw(blue, ship2.body.getPosition().x - 8, ship2.body.getPosition().y - 8, blue.getWidth() / 2, blue.getHeight() / 2, blue.getWidth() * 2, blue.getHeight() * 2, 1, 1, ship2.body.getAngle() * MathUtils.radiansToDegrees, 0, 0, 32, 32, false, true);
		}
		for(int i = 0;i<bullets.size();i++){
			bullets.get(i).render(batch);
		}
		batch.end();
		fixedgunlol.shewt(ship,true);
		moveit.move(ship,true);
		fixedgunlol.shewt(ship2,false);
		moveit.move(ship2,false);
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