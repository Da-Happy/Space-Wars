package space.wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class moveit {
    public static void move(SpaceShip ship, boolean prime) {
        int mult = 10;
        Vector2 direction = new Vector2(0, -1).rotateRad(ship.body.getAngle());
        if(prime) {
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
                ship.body.setAngularVelocity(-3);

            }
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
                ship.body.setAngularVelocity(3);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
                ship.body.applyForceToCenter(direction.x * mult, direction.y * mult, true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
                ship.body.applyForceToCenter(direction.x * -mult, direction.y * -mult, true);
            }
            if(!Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && !Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) && ship.body.getAngularVelocity() != 0){
                ship.body.setAngularVelocity(0);
            }
        } else{
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                ship.body.setAngularVelocity(-3);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                ship.body.setAngularVelocity(3);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                ship.body.applyForceToCenter(direction.x * mult, direction.y * mult, true);

            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                ship.body.applyForceToCenter(direction.x * -mult, direction.y * -mult, true);
            }
            if(!Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.D) && ship.body.getAngularVelocity() != 0){
                ship.body.setAngularVelocity(0);
            }
        }

    }

}