package Input;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class InputTest extends TestCase {

    @Test
    @DisplayName("Returns false with invalid inputs in terms of size of the input array")
    public void test_inputValidatorInvalidInput(){
        //Arrange
        List<String> inputString = List.of();
        List<String> inputString1 = List.of("5 5");
        List<String> inputString2 = List.of("5 5", "LMLMRLMLR");
        List<String> inputString3 = List.of("5 5","1 2 N","MMLMLRML","10 10");
        Input input = new Input();
        //Assert
        assertFalse(input.inputValidator(inputString));
        assertFalse(input.inputValidator(inputString1));
        assertFalse(input.inputValidator(inputString2));
        assertFalse(input.inputValidator(inputString3));
    }

    @Test
    @DisplayName("Returns false with invalid plateau size input")
    public void test_inputValidatorInvalidPlateauSize(){
        //Arrange
        List<String> inputString = List.of("5", "1 2 N", "LMMLRML");
        Input input = new Input();
        //Assert
        assertFalse(input.inputValidator(inputString));
    }

    @Test
    @DisplayName("Returns false with invalid starting position input")
    public void test_inputValidatorInvalidStartingPosition(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2", "LMMLRML");
        Input input = new Input();
        //Assert
        assertFalse(input.inputValidator(inputString));
    }

    @Test
    @DisplayName("Returns false with invalid instruction input")
    public void test_inputValidatorInvalidInstructions(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2 N", "AAA");
        Input input = new Input();
        //Assert
        assertFalse(input.inputValidator(inputString));
    }

    @Test
    @DisplayName("Returns true with valid input")
    public void test_inputValidatorValidInput(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2 N", "MMLRMLRM");
        Input input = new Input();
        //Assert
        assertTrue(input.inputValidator(inputString));
    }

    @Test
    @DisplayName("Returns true with valid input with multiple rovers")
    public void test_inputValidatorValidInputMultipleRovers(){
        //Arrange
        List<String> inputString = List.of("5 5", "1 2 N", "MMLRMLRM","3 3 E","LLRRMMMRMRLM");
        Input input = new Input();
        //Assert
        assertTrue(input.inputValidator(inputString));
    }


}