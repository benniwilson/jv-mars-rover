package InputParsing;

import Main.Instruction;
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
        InstructionParser instructionParser = new InstructionParser("");
        //Act
        List<Instruction> result = instructionParser.parseInstruction();
        List<Instruction> expected = new ArrayList<>();
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Instruction parser returns an empty array list with an invalid input")
    public void test_InstructionParserInvalidInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser("PPP");
        //Act
        List<Instruction> result = instructionParser.parseInstruction();
        List<Instruction> expected = new ArrayList<>();
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Instruction parser returns correct with lowercase input")
    public void test_InstructionParserLowerCaseInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser("m");
        //Act
        List<Instruction> result = instructionParser.parseInstruction();
        List<Instruction> expected = List.of(Instruction.M);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Instruction parser returns correct with multiple inputs")
    public void test_InstructionParserLongerInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser("MMLRRLMMLR");
        //Act
        List<Instruction> result = instructionParser.parseInstruction();
        List<Instruction> expected = List.of(Instruction.M,Instruction.M,Instruction.L,Instruction.R,
                Instruction.R, Instruction.L, Instruction.M,Instruction.M,Instruction.L,Instruction.R);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Instruction parser returns the correct list with lowercase and invalid inputs")
    public void test_InstructionParserLowercaseValidAndInvalidInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser("mmrLUbNMLPR07%R");
        //Act
        List<Instruction> result = instructionParser.parseInstruction();
        List<Instruction> expected = List.of(Instruction.M,Instruction.M,Instruction.R,Instruction.L,
                Instruction.M,Instruction.L,Instruction.R,Instruction.R);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Instruction parser returns the correct list with spaces in the string")
    public void test_InstructionParserSpacedInput(){
        //Arrange
        InstructionParser instructionParser = new InstructionParser("  M R H m r     L");
        //Act
        List<Instruction> result = instructionParser.parseInstruction();
        List<Instruction> expected = List.of(Instruction.M,Instruction.R,Instruction.M,Instruction.R,
                Instruction.L);
        //Assert
        assertEquals(expected, result);
    }
}