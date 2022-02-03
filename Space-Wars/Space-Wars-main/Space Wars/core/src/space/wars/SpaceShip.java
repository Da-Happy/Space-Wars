package space.wars;

import com.badlogic.gdx.physics.box2d.*;

public class SpaceShip {
    BodyDef bodyDef = new BodyDef();
    Body body;

    public SpaceShip(int x, int y) {
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        body = SpaceWars.world.createBody(bodyDef);
        EasyBox core = new EasyBox(4,4,0,0,1f,0.1f,body);
        
    }
}
