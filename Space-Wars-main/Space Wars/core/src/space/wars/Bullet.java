package space.wars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Bullet {
    private final Texture texture;
    public boolean isalive;
    EasyCircle bullet;
    Body body;
    BodyDef bodyDef;
    Vector2 linearthing;
    public Bullet(Vector2 pos, Vector2 direction, float speed) {
        this.texture = new Texture("bulleet1.png");
        this.bodyDef = new BodyDef();
        this.isalive = true;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.bullet = true;
        this.linearthing = meMath.normalize(direction,speed);
        bodyDef.position.set(pos);
        this.body = SpaceWars.world.createBody(bodyDef);
        this.bullet = new EasyCircle((float) 0.1,0,0,1f,1f,body);
        this.body.setUserData(this);
        SpaceWars.bullets.add(this);
    }
    public void render(Batch batch){
        if(this.isalive){
        batch.draw(this.texture, (float) (this.body.getPosition().x-3.8), (float) (this.body.getPosition().y-3.8),this.texture.getWidth()/2,this.texture.getHeight()/2,this.texture.getWidth()/2,this.texture.getHeight()/2,(float) 0.1,(float) 0.1,0,0,0,8,8,false,true);
    }else{
            this.texture.dispose();
        }
    }
}
