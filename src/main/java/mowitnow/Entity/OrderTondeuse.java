package mowitnow.Entity;

public enum OrderTondeuse {
    DROITE('D', "turn to right"),
    GAUCHE('G', "turn to left"),
    AVANCER('A', "advance");

    private String libelleInstruction;
    private char codeInstruction;

    private OrderTondeuse(char pCodeInstruction, String libelleInstruction) {
        this.libelleInstruction = libelleInstruction;
        this.codeInstruction = pCodeInstruction;
    }

    public String getLibelleInstruction() {
        return libelleInstruction;
    }
    public char getCodeInstruction() {
        return codeInstruction;
    }
}
