package Entity;
import mowitnow.Entity.Coordonnees;
import mowitnow.Entity.Pelouse;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
public class PelouseTest {
    @Test
    public void verifier_surcharge_equals() {
        Pelouse p1 = new Pelouse(new Coordonnees(1, 2));
        Pelouse p2 = new Pelouse(new Coordonnees(1, 2));
        assertThat(p1.equals(p2)).isTrue();
        p2 = new Pelouse(new Coordonnees(1, 3));
        assertThat(p1.equals(p2)).isFalse();
    }
}
