package space.wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;

public class SpaceShip {
    boolean sas;
    ArrayList<Integer> inputKeys;
    EasyBox railgun;
    EasyBox core;
    BodyDef bodyDef = new BodyDef();
    Body body;

    public SpaceShip(int x, int y, boolean prime) {
        this.sas = true;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        body = SpaceWars.world.createBody(bodyDef);
        this.core = new EasyBox(4,4,0,0,1f,0.1f,body);
        this.railgun = new EasyBox(1,2,0,-6,1f,0.1f,body);
        this.inputKeys = SpaceWars.test.prime;
        if (!prime) {
            this.inputKeys = SpaceWars.test.nonPrime;
        }
    }
    public void takeInput() {
        Vector2 direction = new Vector2(0, -1).rotateRad(this.body.getAngle());
        if (Gdx.input.isKeyPressed(this.inputKeys.get(0))) {
            this.body.setAngularVelocity(-3);
        }
        if (Gdx.input.isKeyPressed(this.inputKeys.get(1))) {
            this.body.setAngularVelocity(3);
        }
        if (Gdx.input.isKeyPressed(this.inputKeys.get(2))) {
            this.body.applyForceToCenter(direction.x * 1000, direction.y * 1000, true);
        }
        if (Gdx.input.isKeyPressed(this.inputKeys.get(3))) {
            this.body.applyForceToCenter(direction.x * -1000, direction.y * -1000, true);
        }
        if(!Gdx.input.isKeyPressed(this.inputKeys.get(0)) && !Gdx.input.isKeyPressed(this.inputKeys.get(1)) && this.body.getAngularVelocity() != 0 && this.sas){
            this.body.applyAngularImpulse(-this.body.getAngularVelocity()*100,true);
            this.body.setAngularVelocity(0);
        }
        if (Gdx.input.isKeyJustPressed(inputKeys.get(4))) {
            Vector2 bodyPosition = this.body.getPosition();
            Vector2 gunPos = new Vector2(this.railgun.pos.x, this.railgun.pos.y - this.railgun.wY * 2);
            gunPos.rotateRad(this.body.getAngle());
            gunPos.add(bodyPosition);
            Bullet bullet = new Bullet(gunPos, direction, 100000000f);
            bullet.body.applyForceToCenter(bullet.angularVelocity, false);
        }
        if (Gdx.input.isKeyJustPressed(inputKeys.get(5))) {
            this.sas = !this.sas;
        }
    }

    public void render() {
        this.takeInput();
    }
}
