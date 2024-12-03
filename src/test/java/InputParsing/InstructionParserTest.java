package InputParsing;

import Logic.Instruction;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class InstructionParserTest extends TestCase {

    @Test
    @DisplayName("Instruction parser returns an empty array list with no input")
    public void test_InstructionParserNoInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser();
        //Act
        Instruction result = instructionParser.parseInstruction("");
        //Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Instruction parser returns an empty array list with an invalid input")
    public void test_InstructionParserInvalidInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser();
        //Act
        Instruction result = instructionParser.parseInstruction("PPP");
        //Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Instruction parser returns correct with lowercase input")
    public void test_InstructionParserLowerCaseInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser();
        //Act
        Instruction result = instructionParser.parseInstruction("m");
        Instruction expected = Instruction.M;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Instruction parser returns correct with multiple inputs")
    public void test_InstructionParserLongerInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser();
        //Act
        Instruction result = instructionParser.parseInstruction("MMLRRLMMLR");
        Instruction expected = Instruction.M;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Instruction parser returns the correct list with lowercase and invalid inputs")
    public void test_InstructionParserLowercaseValidAndInvalidInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser();
        //Act
        Instruction result = instructionParser.parseInstruction("UUUrLUbNMLPR07%R");
        Instruction expected = Instruction.R;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Instruction parser returns the correct list with spaces in the string")
    public void test_InstructionParserSpacedInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser();
        //Act
        Instruction result = instructionParser.parseInstruction("  H  L R H m r     L");
        Instruction expected = Instruction.L;
        //Assert
        assertEquals(expected, result);
    }
}