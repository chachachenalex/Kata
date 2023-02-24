package mowitnow.services;

import mowitnow.Entity.Coordonnees;
import mowitnow.Entity.Orientation;
import mowitnow.Entity.Pelouse;
import mowitnow.Entity.PositionTondeuse;
import mowitnow.Entity.OrderTondeuse;

import java.util.ArrayList;
import java.util.List;

public class TondeuseUtils {

    private static final String CHAINE_ESPACE = " ";


    public static PositionTondeuse getTonteuseInfo(String ligneTondeuse){
        String[] elts = ligneTondeuse.split(CHAINE_ESPACE);
        Coordonnees pCoordonneesTondeuse = new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
        Orientation orientationTondeuse = getOrientation(elts[2].charAt(0));
        return new PositionTondeuse(pCoordonneesTondeuse, orientationTondeuse);
    }

    /**
     * récuperer l'objet Pelouse contenant les coordonnées limites de la pelouse
     * @param lignePelouse : ligne de la pelouse ( ex : 2 3)
     * @return l'objet qui définit la limite de la pelouse
     */
    public static Pelouse getPelouseInfo(String lignePelouse){
        String[] elts = lignePelouse.split(CHAINE_ESPACE);
        return new Pelouse(new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
    }

    /**
     * récuperer une liste d'enum InstructionTondeuse correspondante à la ligne d'instruction
     * @param ligneInstruction : suite d'instruction ( ex : GDAGD)
     * @return une liste d'enum InstrctionTondeuse
     */
    public static List<OrderTondeuse> getInstructionsInfo(String ligneInstruction){
        List<OrderTondeuse> listInstruction = new ArrayList<OrderTondeuse>();
        for(char instruction :ligneInstruction.toCharArray()){
            listInstruction.add(getInstruction(instruction));
        }
        return listInstruction;
    }

    /**
     * récuperer un enum Orientation correspondant au caractère de l'orientation
     * @param cOrientation : caractère de l'orientation (E, W, N, S)
     * @return l'enum correspondant à l'orientation
     */
    public static Orientation getOrientation(char cOrientation){
        for(Orientation orientation : Orientation.values()) {
            if (orientation.getCodeOrientation() == cOrientation){
                return orientation;
            }
        }
        return null;
    }

    /**
     * récuperer un enum InstructionTondeuse correspondant au caractère d'instrction
     * @param cInstruction : caractère de l'instruction (A, G, D)
     * @return l'enum correspondant à l'instruction
     */
    public static OrderTondeuse getInstruction(char cInstruction){
        for(OrderTondeuse instruction : OrderTondeuse.values()) {
            if (instruction.getCodeInstruction() == cInstruction) {
                return instruction;
            }
        }
        return null;
    }
}

