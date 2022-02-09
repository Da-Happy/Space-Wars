package space.wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class fixedgunlol {

    public static void shewt(SpaceShip ship,boolean prime){
        Vector2 pos = ship.railgun.pos;
        if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT) && !prime) {
//            ammo = ammo-1;
            Vector2 bodyPosition = ship.body.getPosition();
            Vector2 gunPos = new Vector2(pos.x,pos.y-ship.railgun.wY*2);
            gunPos.rotateRad(ship.body.getAngle());
            Vector2 direction = new Vector2(0,-1).rotateRad(ship.body.getAngle());
            gunPos.add(bodyPosition);
            Bullet bullet = new Bullet(gunPos,direction,100000000f);
            bullet.body.applyForceToCenter(bullet.angularVelocity,false);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_RIGHT) && prime) {
//            ammo = ammo-1;
            Vector2 bodyPosition = ship.body.getPosition();
            Vector2 gunPos = new Vector2(pos.x,pos.y-ship.railgun.wY*2);
            gunPos.rotateRad(ship.body.getAngle());
            Vector2 direction = new Vector2(0,-1).rotateRad(ship.body.getAngle());
            gunPos.add(bodyPosition);
            Bullet bullet = new Bullet(gunPos,direction,10000000);
            bullet.body.applyForceToCenter(bullet.angularVelocity,false);
        }
    }
}