package space.wars;

import com.badlogic.gdx.math.Vector2;

public class meMath {
    public static Vector2 normalize(Vector2 vector2, float mul) {
        float x = vector2.x;
        float y = vector2.y;
        float sum = Math.abs(x)+Math.abs(y);
        x = x/sum*mul;
        y = y/sum*mul;
        return (new Vector2(x,y));
    }
}
