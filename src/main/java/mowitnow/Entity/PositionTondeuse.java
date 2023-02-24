package mowitnow.Entity;

public class PositionTondeuse {
    private Coordonnees coordonneesTondeuse;

    public Coordonnees getCoordonneesTondeuse() {
        return coordonneesTondeuse;
    }

    public void setCoordonneesTondeuse(Coordonnees coordonneesTondeuse) {
        this.coordonneesTondeuse = coordonneesTondeuse;
    }

    public Orientation getOrientationTondeuse() {
        return orientationTondeuse;
    }

    public void setOrientationTondeuse(Orientation orientationTondeuse) {
        this.orientationTondeuse = orientationTondeuse;
    }

    private Orientation orientationTondeuse;

    public PositionTondeuse(Coordonnees pCoordonneesTondeuse,
                            Orientation pOrientationTondeuse) {
        this.coordonneesTondeuse = pCoordonneesTondeuse;
        this.orientationTondeuse = pOrientationTondeuse;
    }
}
