package services;

import mowitnow.Entity.Coordonnees;
import mowitnow.Entity.OrderTondeuse;
import mowitnow.Entity.Orientation;
import mowitnow.Entity.Pelouse;
import mowitnow.services.TondeuseUtils;
import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

public class TondeuseUtilsTest {
    @Test
    public void getTonteuseInfo() {
        assertThat(TondeuseUtils.getTonteuseInfo("10 15 N").getCoordonneesTondeuse()).isEqualTo(new Coordonnees(10, 15));
        assertThat(TondeuseUtils.getTonteuseInfo("10 15 N").getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void getPelouseInfo() {
        assertThat(TondeuseUtils.getPelouseInfo("10 15")).isEqualTo(new Pelouse(new Coordonnees(10, 15)));
    }

    @Test
    public void getInstructionInfo() {
        assertThat(TondeuseUtils.getInstructionsInfo("DGAD")).hasSize(4)
                .contains(OrderTondeuse.DROITE)
                .contains(OrderTondeuse.GAUCHE)
                .contains(OrderTondeuse.AVANCER);
    }

    @Test
    public void recuperer_orientation() {
        assertThat(TondeuseUtils.getOrientation('E')).isEqualTo(Orientation.EAST);
        assertThat(TondeuseUtils.getOrientation('N')).isEqualTo(Orientation.NORTH);
        assertThat(TondeuseUtils.getOrientation('S')).isEqualTo(Orientation.SOUTH);
        assertThat(TondeuseUtils.getOrientation('W')).isEqualTo(Orientation.WEST);
        assertThat(TondeuseUtils.getOrientation('a')).isNull();
    }

    @Test
    public void testGetInstruction() {
        assertThat(TondeuseUtils.getInstruction('A')).isEqualTo(OrderTondeuse.AVANCER);
        assertThat(TondeuseUtils.getInstruction('D')).isEqualTo(OrderTondeuse.DROITE);
        assertThat(TondeuseUtils.getInstruction('G')).isEqualTo(OrderTondeuse.GAUCHE);
        assertThat(TondeuseUtils.getInstruction(' ')).isNull();
    }
}
