package space.wars;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

import java.util.HashMap;

public class SplinterRound {
    Body[] bodies;
    EasyCircle[] bullets;
    int numShots;
    EasyCircle bullet;
    Body body;
    BodyDef bodyDef;
    Vector2 angularVelocity;

    public SplinterRound(Vector2 pos, float speed) {
        this.bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.bullet = true;
        bodyDef.position.set(pos);
        this.numShots = (int) Math.ceil(Math.random()*5);
        for(int i = 0; i < this.numShots;){
            this.angularVelocity = meMath.normalize(pos,speed);
            this.bodies[i] = SpaceWars.world.createBody(bodyDef);
            this.bullets[i] = new EasyCircle(1,0,0,1f,0.1f, this.bodies[i]);
            this.angularVelocity.rotateDeg((float) (Math.random()*3-Math.random()*3));
            this.bodies[i].applyForceToCenter((Vector2) this.angularVelocity, true);
        }

    }
}
