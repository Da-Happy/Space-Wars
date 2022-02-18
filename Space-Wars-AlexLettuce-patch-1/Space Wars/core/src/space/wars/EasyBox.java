package space.wars;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
public class EasyBox {
    int wX;
    int wY;
    int x;
    int y;
    Vector2 pos;
    public Fixture fixtureName;
    public PolygonShape shape = new PolygonShape();
    public FixtureDef fixtureDef = new FixtureDef();

    public EasyBox(int wX, int wY, int x, int y, float density, float restitution, Body body) {
        this.wX = wX;
        this.wY = wY;
        this.x = x;
        this.y = y;
        this.pos = new Vector2(x,y);
        this.shape.setAsBox(wX,wY,pos,0f);
        this.fixtureDef.shape = shape;
        this.fixtureDef.density = density;

        this.fixtureDef.restitution = restitution;
        this.fixtureName = body.createFixture(this.fixtureDef);
        this.fixtureName.setUserData(this);
    }
}
