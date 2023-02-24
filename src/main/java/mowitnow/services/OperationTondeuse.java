package mowitnow.services;

import mowitnow.Entity.Pelouse;
import mowitnow.Entity.PositionTondeuse;
import mowitnow.ExceptionTondeuse;
import mowitnow.Entity.OrderTondeuse;

import java.util.ArrayList;
import java.util.List;

public class OperationTondeuse {
    private Pelouse pelouse;
    private PositionTondeuse positionTondeuse;
    private List<OrderTondeuse> orderTondeuseList;

    public void setPelouse(Pelouse pelouse) {
        this.pelouse = pelouse;
    }

    public void setPositionTondeuse(PositionTondeuse positionTondeuse) {
        this.positionTondeuse = positionTondeuse;
    }

    public void setListeInstruction(
            List<OrderTondeuse> orderTondeuseList) {
           this.orderTondeuseList = orderTondeuseList;
        if(orderTondeuseList == null){
            this.orderTondeuseList = new ArrayList<OrderTondeuse>();
        }
    }
    /**
     * executer l'ensemble des insctructions par une tondeuse
     * @throws ExceptionTondeuse
     */
    public void executerInstructions() throws ExceptionTondeuse {
        for(OrderTondeuse order : orderTondeuseList){
            OperationInstruction.executerInstruction(positionTondeuse,
                    order, this.pelouse.getPositionMax());
        }
    }

    public String toString(){
        return 	positionTondeuse.getCoordonneesTondeuse().getX()
                + " "
                + positionTondeuse.getCoordonneesTondeuse().getY()
                + " "
                + positionTondeuse.getOrientationTondeuse().getCodeOrientation() ;
    }
}
