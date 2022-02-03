package space.wars;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Bullet {
    EasyBox bullet;
    Body body;
    BodyDef bodyDef;
    Vector2 angularVelocity;

    public Bullet(Vector2 barrelTipLoc, Vector2 direction, float speed) {
        this.bodyDef = new BodyDef();
        bodyDef.bullet = true;
        this.angularVelocity = meMath.normalize(direction,speed);
        bodyDef.position.set(barrelTipLoc.add(angularVelocity));
        this.body = SpaceWars.world.createBody(bodyDef);
        this.bullet = new EasyBox(4,4,0,0,1f,0.1f,body);
        this.body.applyForceToCenter(this.angularVelocity,true);

    }
}
