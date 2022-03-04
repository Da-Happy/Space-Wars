package space.wars;

import com.badlogic.gdx.physics.box2d.*;

public class CollisionListener implements ContactListener{
    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        if(fa == null || fb == null) return;
        if(fa.getUserData() == null || fa.getUserData() == null) return;
        if(fa.getBody().isBullet()){
            SpaceWars.queue.add(fa.getBody());
            ((Bullet) fa.getBody().getUserData()).isalive = false;
    }
        if(fb.getBody().isBullet()){
            SpaceWars.queue.add(fb.getBody());
            ((Bullet) fb.getBody().getUserData()).isalive = false;
        }
        if(!fa.getBody().isBullet()){
            SpaceShip faShip = (SpaceShip) fa.getBody().getUserData();
            faShip.health--;
        }
        if(!fb.getBody().isBullet()){
            SpaceShip fbShip = (SpaceShip) fb.getBody().getUserData();
            fbShip.health--;
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    //dont worry about these two
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}

