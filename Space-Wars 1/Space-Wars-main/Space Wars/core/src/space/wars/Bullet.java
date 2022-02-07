package space.wars;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Bullet {
    EasyCircle bullet;
    Body body;
    BodyDef bodyDef;
    Vector2 angularVelocity;

    public Bullet(Vector2 pos, float speed) {
        this.bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.bullet = true;
        this.angularVelocity = meMath.normalize(pos,speed);
        bodyDef.position.set(pos);
        this.body = SpaceWars.world.createBody(bodyDef);
        this.bullet = new EasyCircle(1,0,0,1f,0.1f,body);
        System.out.println(this.body.getPosition());
        this.angularVelocity = meMath.normalize(pos,speed);

    }
}
