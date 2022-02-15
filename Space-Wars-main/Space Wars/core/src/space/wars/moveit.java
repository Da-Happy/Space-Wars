package space.wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class moveit {
    public static void move(SpaceShip ship, boolean prime) {
        Vector2 direction = new Vector2(0, -1).rotateRad(ship.body.getAngle());
        if(prime) {
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
                ship.body.applyAngularImpulse(-25, true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
                ship.body.applyAngularImpulse(25, true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
                ship.body.applyForceToCenter(direction.x * 1000, direction.y * 1000, true);

            }
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
                ship.body.applyForceToCenter(direction.x * -1000, direction.y * -1000, true);
            }
            if(ship.sas) {
                float spin = ship.body.getAngularVelocity();
                int spinNormal = (int) (spin/Math.abs(spin));
                System.out.println(spinNormal);
                ship.body.applyAngularImpulse(-spinNormal*5, true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
                ship.sas = !ship.sas;
            }
        } else {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                ship.body.applyAngularImpulse(-25, true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                ship.body.applyAngularImpulse(25, true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                ship.body.applyForceToCenter(direction.x * 1000, direction.y * 1000, true);

            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                ship.body.applyForceToCenter(direction.x * -1000, direction.y * -1000, true);
            }    
            if(ship.sas) {
                float spin = ship.body.getAngularVelocity();
                int spinNormal = (int) (spin/Math.abs(spin));
                ship.body.applyAngularImpulse(-spinNormal*25, true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
                ship.sas = !ship.sas;
            }
        }

    }

}