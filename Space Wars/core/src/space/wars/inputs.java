package space.wars;
import com.badlogic.gdx.Input.Keys.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.badlogic.gdx.Input.Keys.*;


public class inputs {
    public ArrayList<Integer> prime;
    public ArrayList<Integer> nonPrime;

    public inputs() {
        prime = new ArrayList<>();
        nonPrime = new ArrayList<>();

        this.prime.add(A);
        this.prime.add(D);
        this.prime.add(W);
        this.prime.add(S);
        this.prime.add(SHIFT_LEFT);
        this.prime.add(Q);

        this.nonPrime.add(DPAD_LEFT);
        this.nonPrime.add(DPAD_RIGHT);
        this.nonPrime.add(DPAD_UP);
        this.nonPrime.add(DPAD_DOWN);
        this.nonPrime.add(SHIFT_RIGHT);
        this.nonPrime.add(CONTROL_RIGHT);
    }
}
