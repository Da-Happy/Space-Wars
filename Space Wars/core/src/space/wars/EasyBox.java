package space.wars;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class EasyBox {
    public Fixture fixtureName;
    public PolygonShape fixtureShape = new PolygonShape();
    public FixtureDef fixtureDef = new FixtureDef();

    public EasyBox(int wX, int wY, int x, int y, float density, float restitution, Body body) {
        Vector2 pos = new Vector2(x,y);
        this.fixtureShape.setAsBox(wX,wY,pos,0f);
        this.fixtureDef.shape = fixtureShape;
        this.fixtureDef.density = density;

        this.fixtureDef.restitution = restitution;
        this.fixtureName = body.createFixture(this.fixtureDef);
    }
}
