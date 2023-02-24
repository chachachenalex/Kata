package mowitnow.parser;


public class ParserInstructionsData {
    /**
     * check the correction of tondeuse (coordonnees and orientation)
     * @param tondeuse
     * @return true if correct, false else
     */
    public static boolean parseTondeuse(String tondeuse){

        return (tondeuse.matches("(\\d+) (\\d+) N ")||tondeuse.matches("(\\d+) (\\d+) W ")||tondeuse.matches("(\\d+) (\\d+) S ")||tondeuse.matches("(\\d+) (\\d+) E "));
    }

    /**
     * check if the format of instructions data is good or not
     *
     * @param instructions
     * @return true if format is good , else false
     */
    public static boolean parseListInstruction(String instructions){
        for (int i =0;i<instructions.length();i++){
            char c = instructions.charAt(i);
            if (c != 'A' && c != 'D' && c!='G'){
                return false;
            }
        }
        return true;
    }

    /**
     * check the correct of pelouse
     * @param pelouse
     * @return true format correct false else
     */
    public static boolean parsePelouse(String pelouse){
        return pelouse.matches("(\\d+) (\\d+)");
    }
}
