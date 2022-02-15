package space.wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class fixedgunlol {
    public static void shewt(SpaceShip ship){
        float angle = ship.body.getAngle();
        Vector2 pos = ship.railgun.pos;
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && SpaceWars.overheat == 0) {
//            ammo = ammo-1;
            SpaceWars.overheat = 10;
            Vector2 bodyPosition =  ship.body.getPosition();
            Vector2 gunPos = new Vector2(pos.x+ship.railgun.wX,pos.y+ship.railgun.wY);
            gunPos.rotateRad(angle);
            gunPos.rotate90(1);
            gunPos.add(bodyPosition);
            System.out.println(gunPos);
            Bullet bullet = new Bullet(gunPos, 100000000f);
            bullet.body.applyForceToCenter(bullet.angularVelocity,false);

        }
    }
}