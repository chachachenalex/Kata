package Parser;

import mowitnow.parser.ParserInstructionsData;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ParserInstructionsDataTest {
    @Test
    public void parse_tondeuse(){
        assertThat(ParserInstructionsData.parseTondeuse("")).isFalse();
        assertThat(ParserInstructionsData.parseTondeuse("1 2 3")).isFalse();
        assertThat(ParserInstructionsData.parseTondeuse("12N")).isFalse();
        assertThat(ParserInstructionsData.parseTondeuse("1 2 N")).isTrue();
        assertThat(ParserInstructionsData.parseTondeuse("1 2 S")).isTrue();
    }

    @Test
    public void parse_liste_instruction(){
        assertThat(ParserInstructionsData.parseListInstruction("")).isFalse();
        assertThat(ParserInstructionsData.parseListInstruction(" ")).isFalse();
        assertThat(ParserInstructionsData.parseListInstruction("D G")).isFalse();
        assertThat(ParserInstructionsData.parseListInstruction("GGAAAGADDAN")).isFalse();
        assertThat(ParserInstructionsData.parseListInstruction("GGAAAG ADDAN")).isFalse();
        assertThat(ParserInstructionsData.parseListInstruction("DGA")).isTrue();
        assertThat(ParserInstructionsData.parseListInstruction("GGAAAGADDA")).isTrue();
    }

    @Test
    public void parse_pelouse(){
        assertThat(ParserInstructionsData.parsePelouse("")).isFalse();
        assertThat(ParserInstructionsData.parsePelouse("1 2 3")).isFalse();
        assertThat(ParserInstructionsData.parsePelouse("123")).isFalse();
        assertThat(ParserInstructionsData.parsePelouse("1 2 ")).isFalse();
        assertThat(ParserInstructionsData.parsePelouse("1 2")).isTrue();
        assertThat(ParserInstructionsData.parsePelouse("1 N")).isFalse();
    }
}
