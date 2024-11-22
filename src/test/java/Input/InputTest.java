package Input;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class InputTest extends TestCase {

    @Test
    @DisplayName("Returns false with invalid numerical plateau size input")
    public void test_plateauSizeInputValidatorInvalidInput(){
        //Arrange
        List<String> inputString = List.of("5754", "1 2 N", "MMLRMLRM","3 3 E","LLRRMMMRMRLM");
        Input input = new Input(inputString);
        //Assert
        assertFalse(input.plateauSizeInputValidator());
    }

    @Test
    @DisplayName("Returns false with invalid character plateau size input")
    public void test_plateauSizeInputValidatorCharInput(){
        //Arrange
        List<String> inputString = List.of("HELLO", "1 2 N", "MMLRMLRM","3 3 E","LLRRMMMRMRLM");
        Input input = new Input(inputString);
        //Assert
        assertFalse(input.plateauSizeInputValidator());
    }

    @DisplayName("Returns true with valid plateau size input")
    public void test_plateauSizeInputValidatorValid(){
        //Arrange
        List<String> inputString = List.of("7 7");
        Input input = new Input(inputString);
        //Assert
        assertTrue(input.plateauSizeInputValidator());
    }

    @Test
    @DisplayName("Returns false with invalid starting position input")
    public void test_positionParserValidatorInvalidStartingPosition(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2", "LMMLRML");
        Input input = new Input(inputString);
        //Assert
        assertFalse(input.positionParserInputValidator());
    }

    @Test
    @DisplayName("Returns false with invalid starting position input")
    public void test_positionParserValidatorGreaterThanPlateau(){
        //Arrange
        List<String> inputString = List.of("5 5", "12 3 N", "LMMLRML");
        Input input = new Input(inputString);
        //Assert
        assertFalse(input.positionParserInputValidator());
    }

    @Test
    @DisplayName("Returns false with a valid rover followed by an invalid starting position input rover")
    public void test_positionParserValidatorValidThenInvalid(){
        //Arrange
        List<String> inputString = List.of("5 5", "4 3 N", "LMMLRML", "54 232 S", "MMMMLRLRM");
        Input input = new Input(inputString);
        //Assert
        assertFalse(input.positionParserInputValidator());
    }

    @Test
    @DisplayName("Returns true with multiple valid rovers, and the positionParserStrings has the correct strings")
    public void test_positionParserValidatorValid(){
        //Arrange
        List<String> inputString = List.of("5 5", "4 3 N", "LMMLRML", "1 3 S", "MMMMLRLRM");
        Input input = new Input(inputString);
        //Act
        List<String> result = input.positionParserStrings;
        List<String> expected = List.of("4 3 N", "1 3 S");
        //Assert
        assertTrue(input.positionParserInputValidator());
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Returns false with invalid instruction input")
    public void test_instructionInputValidatorInvalidInstructions(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2 N", "AAA");
        Input input = new Input(inputString);
        //Assert
        assertFalse(input.instructionParserInputValidator());
    }

    @Test
    @DisplayName("Returns true with valid instruction input")
    public void test_instructionInputValidatorValidInstructions(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2 N", "MMLRMLRM");
        Input input = new Input(inputString);
        //Act
        List<String> result = input.instructionParserStrings;
        List<String> expected = List.of("MMLRMLRM");
        //Assert
        assertTrue(input.instructionParserInputValidator());
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Returns true with multiple valid rovers")
    public void test_instructionInputValidatorMultipleRovers(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2 N", "MMLRMLRM", "2 5 S", "LLRRLRMMRLM");
        Input input = new Input(inputString);
        //Act
        List<String> result = input.instructionParserStrings;
        List<String> expected = List.of("MMLRMLRM","LLRRLRMMRLM");
        //Assert
        assertTrue(input.instructionParserInputValidator());
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Returns false with invalid inputs in terms of size of the input array")
    public void test_inputValidatorInvalidInput(){
        //Arrange
        List<String> inputString = List.of();
        List<String> inputString1 = List.of("5 5");
        List<String> inputString2 = List.of("5 5", "LMLMRLMLR");
        List<String> inputString3 = List.of("5 5","1 2 N","MMLMLRML","10 10");
        Input input = new Input(inputString);
        Input input1 = new Input(inputString1);
        Input input2 = new Input(inputString2);
        Input input3 = new Input(inputString3);
        //Assert
        assertFalse(input.inputValidator());
        assertFalse(input1.inputValidator());
        assertFalse(input2.inputValidator());
        assertFalse(input3.inputValidator());
    }


    @Test
    @DisplayName("Returns true with valid input and has the correct values in the parserStrings lists")
    public void test_inputValidatorValidInput(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2 N", "MMLRMLRM");
        Input input = new Input(inputString);
        //Act
        List<String> expectedPosition = List.of("1 2 N");
        List<String> resultPosition = input.positionParserStrings;
        List<String> expectedInstruction = List.of("MMLRMLRM");
        List<String> resultInstruction = input.instructionParserStrings;
        //Assert
        assertTrue(input.inputValidator());
        assertEquals(expectedInstruction, resultInstruction);
        assertEquals(expectedPosition, resultPosition);
    }

    @Test
    @DisplayName("Returns true with valid input with multiple rovers")
    public void test_inputValidatorValidInputMultipleRovers(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2 N", "MMLRMLRM","3 3 E","LLRRMMMRMRLM");
        Input input = new Input(inputString);
        //Act
        List<String> expectedPosition = List.of("1 2 N","3 3 E");
        List<String> resultPosition = input.positionParserStrings;
        List<String> expectedInstruction = List.of("MMLRMLRM", "LLRRMMMRMRLM");
        List<String> reusltInstruction = input.instructionParserStrings;
        //Assert
        assertTrue(input.inputValidator());
        assertEquals(expectedInstruction, reusltInstruction);
        assertEquals(expectedPosition, resultPosition);
    }
}