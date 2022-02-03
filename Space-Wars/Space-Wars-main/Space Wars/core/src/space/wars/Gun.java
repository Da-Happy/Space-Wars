package space.wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Gun {
    public static void shoot(SpaceShip ship) {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            Vector2 mouse =  new Vector2(Gdx.input.getX()-Gdx.graphics.getHeight()/2,Gdx.input.getY()-Gdx.graphics.getHeight()/2);
            mouse = meMath.normalize(mouse,240);
            Vector2 vector = mouse.sub(ship.body.getPosition());
            System.out.println(mouse);
            Bullet bullet = new Bullet(ship.body.getPosition(),vector, 10f);
        }
    }
}
