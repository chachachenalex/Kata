package mowitnow.Entity;

public class Pelouse {
    private Coordonnees positionMax;

    public Pelouse(Coordonnees pPositionMax) {
        this.positionMax = pPositionMax;
    }

    public Coordonnees getPositionMax() {
        return positionMax;
    }

    public void setPositionMax(Coordonnees positionMax) {
        this.positionMax = positionMax;
    }
}
