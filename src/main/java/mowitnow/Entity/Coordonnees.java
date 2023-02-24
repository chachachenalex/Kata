package mowitnow.Entity;

public class Coordonnees {
    private int x;
    private int y;

    public Coordonnees(int pX, int pY){
        this.x = pX;
        this.y = pY;
    }

    /**
     * check if tondeuse is out of area of Pelouse
     * @param c
     * @return true if outside, else false
     */
    public boolean isOutsideOfPelouse(Coordonnees c){
        return c.getX() >= 0
                && c.getY() >= 0
                && c.getX() <= this.x
                && c.getY() <= this.y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordonnees other = (Coordonnees) obj;
        if (x != other.x || y != other.y)
            return false;

        return true;
    }
}
