package mowitnow.services;

import mowitnow.Constant;
import mowitnow.Entity.Coordonnees;
import mowitnow.Entity.Orientation;
import mowitnow.Entity.PositionTondeuse;
import mowitnow.ExceptionTondeuse;
import mowitnow.Entity.OrderTondeuse;

public class OperationInstruction {
    /**
     * faire avancer la tondeuse
     * @param positionTondeuse : position initiale de la tondeuse
     * @param coordonnesMax : coordonnees de la pelouse - coin superieur droit de la pelouse
     * @return coordonnees : nouvelles coordonnees de la tondeuse
     * @throws ExceptionTondeuse
     */
    public static Coordonnees advanceTondeuse(PositionTondeuse positionTondeuse, Coordonnees coordonnesMax) throws ExceptionTondeuse {
        Coordonnees coordonneesSuivantes = null;
        int x, y;
        switch (positionTondeuse.getOrientationTondeuse()) {
            case NORTH:
                x = positionTondeuse.getCoordonneesTondeuse().getX();
                y = positionTondeuse.getCoordonneesTondeuse().getY() + 1;
                break;
            case EAST:
                x = positionTondeuse.getCoordonneesTondeuse().getX() + 1;
                y = positionTondeuse.getCoordonneesTondeuse().getY();
                break;
            case SOUTH:
                x = positionTondeuse.getCoordonneesTondeuse().getX();
                y = positionTondeuse.getCoordonneesTondeuse().getY() - 1;
                break;
            case WEST:
                x = positionTondeuse.getCoordonneesTondeuse().getX() - 1;
                y = positionTondeuse.getCoordonneesTondeuse().getY();
                break;
            default:
                throw new ExceptionTondeuse(Constant.POSITION_INCORRECTE);
        }
        coordonneesSuivantes = new Coordonnees(x, y);
        // si les nouvelles coordonnées sont en dehors de la pelouse, on garde
        // la derniere position connue
        if (coordonneesSuivantes != null
                && coordonnesMax.isOutsideOfPelouse(coordonneesSuivantes)) {
            return coordonneesSuivantes;
        } else {
            return positionTondeuse.getCoordonneesTondeuse();
        }
    }

    /**
     * faire pivoter la tondeuse à droite
     * @param orientation : orientation initiale de la tondeuse
     * @return nouvelle orientation
     * @throws ExceptionTondeuse
     */

    public static Orientation turnRight(Orientation orientation) throws ExceptionTondeuse{
        Orientation orientationSuivante = null ;
        switch (orientation){
            case NORTH :
                orientationSuivante =  Orientation.EAST;
                break;
            case EAST :
                orientationSuivante =  Orientation.SOUTH;
                break;
            case SOUTH :
                orientationSuivante =  Orientation.WEST;
                break;
            case WEST :
                orientationSuivante =  Orientation.NORTH;
                break;
            default :
                throw new ExceptionTondeuse(Constant.ORIENTATION_INCORRECTE);
        }
        return orientationSuivante;
    }

    /**
     * pivoter la tondeuse à gauche
     * @param orientation : orientation initale de la tondeuse
     * @return nouvelle orientation
     * @throws ExceptionTondeuse
     */
    public static Orientation turnLeft(Orientation orientation) throws ExceptionTondeuse{
        Orientation orientationSuivante = null ;
        switch (orientation){
            case NORTH :
                orientationSuivante =  Orientation.WEST;
                break;
            case EAST :
                orientationSuivante =  Orientation.NORTH;
                break;
            case SOUTH :
                orientationSuivante =  Orientation.EAST;
                break;
            case WEST :
                orientationSuivante =  Orientation.SOUTH;
                break;
            default :
                throw new ExceptionTondeuse(Constant.ORIENTATION_INCORRECTE);
        }
        return orientationSuivante;
    }

    /**
     * executer une seule instruction ( A, D ou G)
     * @param positionTondeuse
     * @param instruction
     * @param coordonnesMax
     * @throws ExceptionTondeuse
     */
    public static void executerInstruction(PositionTondeuse positionTondeuse, OrderTondeuse instruction, Coordonnees coordonnesMax) throws ExceptionTondeuse{

        switch (instruction){
            case AVANCER :
                positionTondeuse.setCoordonneesTondeuse(OperationInstruction.advanceTondeuse(positionTondeuse, coordonnesMax));
                break;
            case DROITE :
                positionTondeuse.setOrientationTondeuse(OperationInstruction.turnRight(positionTondeuse.getOrientationTondeuse()));
                break;
            case GAUCHE :
                positionTondeuse.setOrientationTondeuse(OperationInstruction.turnLeft(positionTondeuse.getOrientationTondeuse()));
                break;
            default: throw new ExceptionTondeuse(Constant.INSTRUCTION_INCORRECTE);
        }
    }
}
