package Entity;

import mowitnow.Entity.Coordonnees;
import mowitnow.Entity.Orientation;
import mowitnow.Entity.PositionTondeuse;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PositionTondeuseTest {

    @Test
    public void verifier_surcharge_equals() {

        PositionTondeuse positionT = new PositionTondeuse(new Coordonnees(5, 5), Orientation.NORTH);
        PositionTondeuse positionTOk = new PositionTondeuse(new Coordonnees(5, 5), Orientation.NORTH);
        PositionTondeuse positionTKo = new PositionTondeuse(new Coordonnees(5, 5), Orientation.SOUTH);

        assertThat(positionT.equals(positionTOk)).isTrue();
        assertThat(positionT.equals(positionTKo)).isFalse();
    }
}
