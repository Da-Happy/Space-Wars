package space.wars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
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
		debugRenderer = new Box2DDebugRenderer(false, true, false, false, false, false);
		camera.setToOrtho(true,500, 500);
		world = new World(new Vector2(0, 0), true);
		world.setContactListener(new CollisionListener());
		batch = new SpriteBatch();
		red = new Texture("red.png");
		blue = new Texture("blue.png");
		buleet = new Texture("bulleet1.png");
		int centerX = round(camera.viewportWidth/2);
		int centerY = round(camera.viewportHeight/2);
		ship = new SpaceShip(centerX+centerX/2,centerY, true);
		ship2 = new SpaceShip(centerX-centerX/2, centerY, false);
	}

	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		world.step(1/60f, 6, 2);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(int i = 1;i<3;i++){
			if(i == 1 && ship.health > 0){
				ship.render(batch)
			} else if(i == 2 && ship2.health > 0){
				ship2.render(batch);
			}
		}

		for(int i = 0;i<bullets.size();i++){
			batch.draw(buleet, bullets.get(i).body.getPosition().x-2,bullets.get(i).body.getPosition().y-2,buleet.getWidth()/2,buleet.getHeight()/2,buleet.getWidth()/2,buleet.getHeight()/2,1,1,0,0,0,8,8,false,true);
		}
		batch.end();

		queue.clear();
		debugRenderer.render(world, camera.combined);
	}

	public void dispose () {

		world.dispose();
		batch.dispose();
	}
}
