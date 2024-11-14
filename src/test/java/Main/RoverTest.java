package Main;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.temporal.ChronoUnit;

public class RoverTest extends TestCase {

    @Test
    @DisplayName("getDirection returns null with null inputs")
    public void test_getDirectionNullInput(){
        //Arrange
        Rover rover = new Rover();
        //Act
        Direction result = rover.getDirection(null, null);
        Direction result1 = rover.getDirection(null, Instruction.M);
        Direction result2 = rover.getDirection(Direction.S, null);
        Direction expected = null;
        //Assert
        assertEquals(expected, result);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
    }

    @Test
    @DisplayName("getDirection returns original direction with move input")
    public void test_getDirectionMoveInput(){
        //Arrange
        Rover rover = new Rover();
        //Act
        Direction result = rover.getDirection(Direction.S, Instruction.M);
        Direction expected = Direction.S;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("getDirection returns correct direction with valid inputs")
    public void test_getDirectionValidInputs(){
        //Arrange
        Rover rover = new Rover();
        //Act
        Direction result = rover.getDirection(Direction.S, Instruction.L);
        Direction expected = Direction.E;
        Direction result1 = rover.getDirection(Direction.E, Instruction.R);
        Direction expected1 = Direction.S;
        Direction result2 = rover.getDirection(Direction.W, Instruction.L);
        Direction expected2 = Direction.S;
        Direction result3 = rover.getDirection(Direction.N, Instruction.R);
        Direction expected3 = Direction.E;
        //Assert
        assertEquals(expected, result);
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @DisplayName("Returns 0 if the inputs are null")
    public void test_getXPositionNullInputs(){
        //Arrange
        Rover rover = new Rover();
        Position currentPosition = null;
        Instruction instruction = null;
        //Act
        int result = rover.getXPosition(currentPosition, instruction);
        int expected = 0;
        //Assert
        assertEquals(expected, result);
    }



}