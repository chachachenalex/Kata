package services;

import mowitnow.Entity.Coordonnees;
import mowitnow.Entity.OrderTondeuse;
import mowitnow.Entity.Orientation;
import mowitnow.Entity.PositionTondeuse;
import mowitnow.ExceptionTondeuse;
import mowitnow.services.OperationInstruction;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class OperationInstructionTest {
    @Test
    public void coordonnees_x_y_south_instruction_Tourner_Droite() throws ExceptionTondeuse {
        Coordonnees coordonnesMax = new Coordonnees(5, 5);
        int x = 2;
        int y = 3;
        Coordonnees coordonnees = new Coordonnees(x, y);
        PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.SOUTH);
        OperationInstruction.executerInstruction(positionTondeuse, OrderTondeuse.DROITE, coordonnesMax);
        assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
        assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.WEST);
    }


    @Test
    public void pivoter_a_droite() throws ExceptionTondeuse{

        Orientation orientationSuivante = OperationInstruction.turnRight(Orientation.EAST);
        assertThat(orientationSuivante).isEqualTo(Orientation.SOUTH);

        orientationSuivante = OperationInstruction.turnRight(Orientation.WEST);
        assertThat(orientationSuivante).isEqualTo(Orientation.NORTH);

        orientationSuivante = OperationInstruction.turnRight(Orientation.NORTH);
        assertThat(orientationSuivante).isEqualTo(Orientation.EAST);

        orientationSuivante = OperationInstruction.turnRight(Orientation.SOUTH);
        assertThat(orientationSuivante).isEqualTo(Orientation.WEST);
    }

    @Test
    public void pivoter_a_gauche() throws ExceptionTondeuse{
        Orientation orientationSuivante = OperationInstruction.turnLeft(Orientation.EAST);
        assertThat(orientationSuivante).isEqualTo(Orientation.NORTH);

        orientationSuivante = OperationInstruction.turnLeft(Orientation.WEST);
        assertThat(orientationSuivante).isEqualTo(Orientation.SOUTH);

        orientationSuivante = OperationInstruction.turnLeft(Orientation.NORTH);
        assertThat(orientationSuivante).isEqualTo(Orientation.WEST);

        orientationSuivante = OperationInstruction.turnLeft(Orientation.SOUTH);
        assertThat(orientationSuivante).isEqualTo(Orientation.EAST);
    }
}
