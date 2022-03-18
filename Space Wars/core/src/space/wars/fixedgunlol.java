package space.wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class fixedgunlol {

    public static void shewt(SpaceShip ship,boolean prime){
        if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT) && !prime) {
//            ammo = ammo-1;
            Vector2 pos = ship.railgun.pos;
            float spe = (float) ((float) 2*(Math.sqrt(ship.body.getLinearVelocity().x*ship.body.getLinearVelocity().x+ship.body.getLinearVelocity().y*ship.body.getLinearVelocity().y)));
            Vector2 bodyPosition = ship.body.getPosition();
            Vector2 gunPos = new Vector2(pos.x, (float) (pos.y-ship.railgun.wY*2));
            gunPos.rotateRad(ship.body.getAngle());
            Vector2 direction = new Vector2(0,-1).rotateRad(ship.body.getAngle());
            gunPos.add(bodyPosition);
            Bullet bullet = new Bullet(gunPos,direction,spe+10);
            bullet.body.applyForceToCenter(bullet.angularVelocity,true);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_RIGHT) && prime) {
//            ammo = ammo-1;
            Vector2 pos = ship.railgun.pos;
            float spe = (float) ((float) 2*(Math.sqrt(ship.body.getLinearVelocity().x*ship.body.getLinearVelocity().x+ship.body.getLinearVelocity().y*ship.body.getLinearVelocity().y)));
            Vector2 bodyPosition = ship.body.getPosition();
            Vector2 gunPos = new Vector2(pos.x, (float) (pos.y-ship.railgun.wY*2));
            gunPos.rotateRad(ship.body.getAngle());
            Vector2 direction = new Vector2(0,-1).rotateRad(ship.body.getAngle());
            gunPos.add(bodyPosition);
            Bullet bullet = new Bullet(gunPos,direction,spe+10);
            bullet.body.applyForceToCenter(bullet.angularVelocity,true);
        }
    }
}