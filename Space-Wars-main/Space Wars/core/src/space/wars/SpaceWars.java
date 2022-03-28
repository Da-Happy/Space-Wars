package space.wars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
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
	private Texture bg;
	public int s1h;
	public int s2h;
	public SpaceShip ship;
	public SpaceShip ship2;
	public int ConstantOfGravity = 20;
	public Sound sound;
	public Sound boom;
	public Sound pew;
	public static int overheat;
	public static int overheat2;
	public static ArrayList<Body> queue;
	public static ArrayList<Bullet> bullets = new ArrayList<>();
	public void create() {
		queue = new ArrayList<>();
		debugRenderer = new Box2DDebugRenderer(false, true, false, false, false, false);
		camera.setToOrtho(true,80, 50);
		world = new World(new Vector2(0, 0), true);
		world.setContactListener(new CollisionListener());
		batch = new SpriteBatch();
		red = new Texture("red.png");
		blue = new Texture("blue.png");
		buleet = new Texture("bulleet1.png");
		bg = new Texture("bakg.png");
		int centerX = round(camera.viewportWidth/2);
		int centerY = round(camera.viewportHeight/2);
		ship = new SpaceShip(centerX+centerX/2,centerY);
		ship2 = new SpaceShip(centerX-centerX/2, centerY);
		sound = Gdx.audio.newSound(Gdx.files.internal("shoot.wav"));
		boom = Gdx.audio.newSound(Gdx.files.internal("peew.wav"));
		pew = Gdx.audio.newSound(Gdx.files.internal("pew.wav"));
		s1h = ship.health;
		s2h = ship2.health;
	}

	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		world.step(1/60f, 6, 2);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bg,0,0,camera.viewportWidth,camera.viewportHeight);
		if(ship.health < 99) {
			batch.draw(red, ship.body.getPosition().x - 8, ship.body.getPosition().y - 8, (float) (red.getWidth() / 2), (float) (red.getHeight() / 2), (float) (red.getWidth()), red.getHeight(), (float) 0.1, (float) 0.1, ship.body.getAngle() * MathUtils.radiansToDegrees, 0, 0, 16, 16, false, true);
		}
		if(ship2.health < 99) {
			batch.draw(blue, ship2.body.getPosition().x - 8, ship2.body.getPosition().y - 8, blue.getWidth() / 2, blue.getHeight() / 2, blue.getWidth(), blue.getHeight(), (float) 0.1, (float) 0.1, ship2.body.getAngle() * MathUtils.radiansToDegrees, 0, 0, 16, 16, false, true);
		}
		for(int i = 0;i<bullets.size();i++){
			bullets.get(i).render(batch);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_RIGHT)) {
			long id = sound.play(0.2f);
			sound.setPitch(id,2);
		}
		if(ship.body.getPosition().x<0){
			ship.body.setTransform(ship.body.getPosition().x+camera.viewportWidth,ship.body.getPosition().y,ship.body.getAngle());
		} else if(ship.body.getPosition().x>camera.viewportWidth){
			ship.body.setTransform(ship.body.getPosition().x-camera.viewportWidth,ship.body.getPosition().y,ship.body.getAngle());
		}
		if(ship.body.getPosition().y<0){
			ship.body.setTransform(ship.body.getPosition().x,ship.body.getPosition().y+camera.viewportHeight,ship.body.getAngle());
		} else if(ship.body.getPosition().y>camera.viewportHeight){
			ship.body.setTransform(ship.body.getPosition().x,ship.body.getPosition().y- camera.viewportHeight,ship.body.getAngle());
		}
		if(ship2.body.getPosition().x<0){
			ship2.body.setTransform(ship2.body.getPosition().x+camera.viewportWidth,ship2.body.getPosition().y,ship2.body.getAngle());
		} else if(ship2.body.getPosition().x>camera.viewportWidth){
			ship2.body.setTransform(ship2.body.getPosition().x-camera.viewportWidth,ship2.body.getPosition().y,ship2.body.getAngle());
		}
		if(ship2.body.getPosition().y<0){
			ship2.body.setTransform(ship2.body.getPosition().x,ship2.body.getPosition().y+camera.viewportHeight,ship2.body.getAngle());
		} else if(ship2.body.getPosition().y>camera.viewportHeight){
			ship2.body.setTransform(ship2.body.getPosition().x,ship2.body.getPosition().y- camera.viewportHeight,ship2.body.getAngle());
		}
		if(ship.health != s1h){
			s1h = ship.health;
			long id = boom.play(0.2f);
			sound.setPitch(id,2);
		}
		if(ship2.health != s2h){
			s2h = ship2.health;
			long id = boom.play(0.2f);
			sound.setPitch(id,2);
		}


		batch.end();
		fixedgunlol.shewt(ship,true);
		moveit.move(ship,true);
		ship.body.setLinearVelocity(ship.body.getLinearVelocity().limit(10));
		fixedgunlol.shewt(ship2,false);
		moveit.move(ship2,false);
		ship2.body.setLinearVelocity(ship2.body.getLinearVelocity().limit(10));
		for (int i = 0; i < queue.size(); i++) {
			world.destroyBody(queue.get(i));
		}

		queue.clear();
		if(ship.health <= 0){
			queue.add(ship.body);
			long id = pew.play(0.2f);
			sound.setPitch(id,2);
			ship.health = 100;
		}
		if(ship2.health <= 0){
			long id = pew.play(0.2f);
			sound.setPitch(id,2);
			queue.add(ship2.body);
			ship2.health = 100;
		}
		debugRenderer.render(world, camera.combined);
	}

	public void dispose () {
		world.dispose();
		batch.dispose();
		sound.dispose();

	}
}