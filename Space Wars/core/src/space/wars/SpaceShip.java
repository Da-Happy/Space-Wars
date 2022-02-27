package space.wars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;

import static space.wars.SpaceWars.queue;

public class SpaceShip {
    Texture blue;
    Texture red;
    int coreW;
    EasyBox railgun;
    EasyBox core;
    BodyDef bodyDef = new BodyDef();
    Body body;
    int health;
    boolean prime;


    public SpaceShip(int x, int y, boolean prime) {
        this.prime = prime;
        red = new Texture("red.png");
        blue = new Texture("blue.png");
        this.health = 5;
        this.coreW = 4;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        body = SpaceWars.world.createBody(bodyDef);
        this.body.setUserData(this);
        this.core = new EasyBox(coreW,coreW,0,0,1f,0.1f,body);
        this.railgun = new EasyBox(1,2,0,-6,1f,0.1f,body);
    }
    public void render(SpriteBatch batch) {
        if(this.health <= 0){
            queue.add(this.body);
            this.health = 100;
        }
        if(this.prime) {
            batch.draw(red, this.body.getPosition().x-8, this.body.getPosition().y-8,red.getWidth()/2,red.getHeight()/2,red.getWidth()*2,red.getHeight()*2,1,1,this.body.getAngle() * MathUtils.radiansToDegrees,0,0,32,32,false,true);
        } else {
            batch.draw(blue, this.body.getPosition().x-8, this.body.getPosition().y-8,blue.getWidth()/2,blue.getHeight()/2,blue.getWidth()*2,blue.getHeight()*2,1,1,this.body.getAngle() * MathUtils.radiansToDegrees,0,0,32,32,false,true);
        }
        fixedgunlol.shewt(this,this.prime);
        moveit.move(this,this.prime);
    };
}
