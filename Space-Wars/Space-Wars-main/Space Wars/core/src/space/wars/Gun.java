package space.wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Gun {
    static int ammo = 200;

    public static void shoot(SpaceShip ship) {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && ammo > 0 && SpaceWars.overheat == 0) {
//            ammo = ammo-1;
            SpaceWars.overheat = 10;
            Vector2 mouse =  new Vector2(Gdx.input.getX(), Gdx.input.getY());
            System.out.println(mouse);
            Vector2 vector = new Vector2(mouse).sub(ship.body.getPosition());
            Bullet bullet = new Bullet(mouse, ship.body.getPosition(),vector, 100000000f);
            bullet.body.applyForceToCenter(bullet.angularVelocity,false);



        }
    }
}
