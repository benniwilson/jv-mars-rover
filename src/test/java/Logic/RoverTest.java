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
        Position position = null;
        Instruction instruction = null;
        //Act
        rover.getDirection(position, instruction);
        //Assert
        assertNull(position);
    }

    @Test
    @DisplayName("getDirection returns original direction with move input")
    public void test_getDirectionMoveInput(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(2, 4, Direction.W);
        Instruction instruction = Instruction.M;
        //Act
        rover.getDirection(position, instruction);
        Position expected = new Position(2,4, Direction.W);
        //Assert
       assertEquals(expected.getFacing(), position.getFacing());
    }

    @Test
    @DisplayName("getDirection returns correct direction with valid inputs")
    public void test_getDirectionValidInputs(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(5, 4, Direction.E);
        Instruction instruction = Instruction.R;
        Position position1 = new Position(2, 3, Direction.S);
        Instruction instruction1 = Instruction.L;
        Position position2 = new Position(6, 0, Direction.N);
        //Act
        rover.getDirection(position, instruction);
        Position expected = new Position(5,4,Direction.S);
        rover.getDirection(position1,instruction);
        Position expected1 = new Position(2,3,Direction.W);
        rover.getDirection(position2, instruction1);
        Position expected2 = new Position(6,0,Direction.W);

        //Assert
        assertEquals(expected.getFacing(), position.getFacing());
        assertEquals(expected1.getFacing(), position1.getFacing());
        assertEquals(expected2.getFacing(), position2.getFacing());
    }

    @Test
    @DisplayName("Remains null if the inputs are null")
    public void test_moveXPositionNullInputs(){
        //Arrange
        Rover rover = new Rover();
        Position position = null;
        Instruction instruction = null;
        //Act
        rover.moveXPosition(position, instruction);
        //Assert
        assertNull(position);
    }

    @Test
    @DisplayName("Returns the same value if instruction is null")
    public void test_moveXPositionNullInstruction(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(2, 3, Direction.N);
        Instruction instruction = null;
        //Act
        rover.moveXPosition(position, instruction);
        Position expected = new Position(2,3,Direction.N);
        //Assert
        assertEquals(expected.getX(), position.getX());
    }

    @Test
    @DisplayName("Returns the same value if instruction is right or left")
    public void test_moveXPositionWrongInstruction(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(2, 3, Direction.N);
        Instruction instruction = Instruction.R;
        //Act
        rover.moveXPosition(position, instruction);
        Position expected = new Position(2,3,Direction.N);
        //Assert
        assertEquals(expected.getX(), position.getX());
    }

    @Test
    @DisplayName("Returns the correct x value with a valid instruction")
    public void test_moveXPositionValidInstruction(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(2, 3, Direction.E);
        Instruction instruction = Instruction.M;
        Position position1 = new Position(7, 2, Direction.W);
        Instruction instruction1 = Instruction.M;
        //Act
        rover.moveXPosition(position, instruction);
        Position expected = new Position(3,3,Direction.E);
        rover.moveXPosition(position1,instruction1);
        Position expected1 = new Position(6,2,Direction.W);
        //Assert
        assertEquals(expected.getX(), position.getX());
        assertEquals(expected1.getX(), position1.getX());
    }

    @Test
    @DisplayName("Returns the correct x value with consecutive instructions")
    public void test_moveXPositionConsecutiveInstruction(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(4, 7, Direction.E);
        Instruction instruction = Instruction.M;
        //Act
        rover.moveXPosition(position, instruction);
        rover.moveXPosition(position, instruction);
        rover.moveXPosition(position, instruction);
        Position expected = new Position(7,7,Direction.E);
        //Assert
        assertEquals(expected.getX(), position.getX());
    }

    @Test
    @DisplayName("Returns the same value if instruction is null")
    public void test_moveYPositionNullInstruction(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(2, 3, Direction.N);
        Instruction instruction = null;
        //Act
        rover.moveYPosition(position, instruction);
        Position expected = new Position(2,3,Direction.N);
        //Assert
        assertEquals(expected.getY(), position.getY());
    }

    @Test
    @DisplayName("Returns the same value if instruction is right or left")
    public void test_moveYPositionWrongInstruction(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(2, 3, Direction.N);
        Instruction instruction = Instruction.R;
        //Act
        rover.moveYPosition(position, instruction);
        Position expected = new Position(2,3,Direction.N);
        //Assert
        assertEquals(expected.getY(), position.getY());
    }

    @Test
    @DisplayName("Returns the correct y value with a valid instruction")
    public void test_moveYPositionValidInstruction(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(2, 3, Direction.N);
        Instruction instruction = Instruction.M;
        Position position1 = new Position(7, 2, Direction.S);
        Instruction instruction1 = Instruction.M;
        //Act
        rover.moveYPosition(position, instruction);
        Position expected = new Position(2,4,Direction.E);
        rover.moveYPosition(position1,instruction1);
        Position expected1 = new Position(7,1,Direction.W);
        //Assert
        assertEquals(expected.getY(), position.getY());
        assertEquals(expected1.getY(), position1.getY());
    }

    @Test
    @DisplayName("Returns the correct y value with consecutive instructions")
    public void test_moveYPositionConsecutiveInstruction(){
        //Arrange
        Rover rover = new Rover();
        Position position = new Position(4, 7, Direction.N);
        Instruction instruction = Instruction.M;
        //Act
        rover.moveYPosition(position, instruction);
        rover.moveYPosition(position, instruction);
        rover.moveYPosition(position, instruction);
        Position expected = new Position(4,10,Direction.E);
        //Assert
        assertEquals(expected.getY(), position.getY());
        assertEquals(expected.getX(), position.getX());
    }




}