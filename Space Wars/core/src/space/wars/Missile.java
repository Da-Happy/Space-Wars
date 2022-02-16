package space.wars;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Missile {
    Body targetBody;
    Vector2 angularVelocity;
    BodyDef bodyDef;
    Body body;
    EasyBox missile;
    int fuel = 100;
    public Missile(Vector2 pos, Vector2 direction, Body targetBody) {
        this.targetBody = targetBody;
        this.bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.bullet = true;
        bodyDef.position.set(pos);
        this.body = SpaceWars.world.createBody(bodyDef);
        this.missile = new EasyBox(1, 2,0,0,1f,1f,body);
    }
    public void Move() {
        this.targetBody.getPosition().sub(this.body.getPosition());
        fuel--;
        
    }
}
