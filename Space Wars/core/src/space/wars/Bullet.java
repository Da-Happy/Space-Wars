package space.wars;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Bullet {
    EasyCircle bullet;
    Body body;
    BodyDef bodyDef;
    Vector2 angularVelocity;

    public Bullet(Vector2 pos, Vector2 direction, float speed) {
        this.bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.bullet = true;
        this.angularVelocity = meMath.normalize(direction,speed);
        bodyDef.position.set(pos);
        this.body = SpaceWars.world.createBody(bodyDef);
        this.bullet = new EasyCircle(1,0,0,1f,1f,body);
        SpaceWars.bullets.add(this);
    }

    public void removeFromPhysicsWorld() {
                body.setActive(false);
                SpaceWars.world.destroyBody(body);
    }
}
