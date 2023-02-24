package mowitnow.parser;

public class ParserTondeuse {
    private String pelouse ;
    private String tondeuse ;
    private String instructions ;

    public ParserTondeuse(){
        this.pelouse = "";
        this.tondeuse = "";
        this.instructions = "";
    }

    /**
     * @return true if tondeuse information is correct, else false
     */
    public boolean executeParse(){
        return ParserInstructionsData.parseTondeuse(tondeuse)
                && ParserInstructionsData.parsePelouse(pelouse)
                && ParserInstructionsData.parseListInstruction(instructions);
    }

    public String getPelouse() {
        return pelouse;
    }

    public void setPelouse(String pelouse) {
        this.pelouse = pelouse;
    }

    public String getTondeuse() {
        return tondeuse;
    }

    public void setTondeuse(String tondeuse) {
        this.tondeuse = tondeuse;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
