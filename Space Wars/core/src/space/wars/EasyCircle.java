package space.wars;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class EasyCircle {
    public Fixture fixtureName;
    public CircleShape shape = new CircleShape();
    public FixtureDef fixtureDef = new FixtureDef();

    public EasyCircle(int radius, int x, int y, float density, float restitution, Body body) {
        Vector2 pos = new Vector2(x,y);
        this.shape.setRadius(radius);
        this.shape.setPosition(pos);
        this.fixtureDef.shape = shape;
        this.fixtureDef.density = density;

        this.fixtureDef.restitution = restitution;
        this.fixtureName = body.createFixture(this.fixtureDef);
    }
}
