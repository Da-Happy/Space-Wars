package space.wars;

import com.badlogic.gdx.physics.box2d.*;

public class SpaceShip {
    int coreW;
    EasyBox railgun;
    EasyBox core;
    BodyDef bodyDef = new BodyDef();
    Body body;

    public SpaceShip(int x, int y) {
        this.coreW = 4;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        body = SpaceWars.world.createBody(bodyDef);
        this.core = new EasyBox(coreW,coreW,0,0,1f,0.1f,body);
        this.railgun = new EasyBox(1,2,0,-6,1f,0.1f,body);
    }
}
