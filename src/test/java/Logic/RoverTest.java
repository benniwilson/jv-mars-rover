package Logic;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class RoverTest extends TestCase {

    @Test
    @DisplayName("getDirection returns null with null inputs")
    public void test_getDirectionNullInput(){
        //Arrange
        Position position = null;
        Rover rover = new Rover(position);
        Instruction instruction = null;
        //Act
        rover.getDirection(instruction);
        //Assert
        assertNull(rover.position);
    }

    @Test
    @DisplayName("getDirection returns original direction with move input")
    public void test_getDirectionMoveInput(){
        //Arrange
        Position position = new Position(2, 4, Direction.W);
        Rover rover = new Rover(position);
        Instruction instruction = Instruction.M;
        //Act
        rover.getDirection(instruction);
        Position expected = new Position(2,4, Direction.W);
        //Assert
       assertEquals(expected.getFacing(), rover.position.getFacing());
    }

    @Test
    @DisplayName("getDirection returns correct direction with valid inputs")
    public void test_getDirectionValidInputs(){
        //Arrange
        Position position = new Position(5, 4, Direction.E);
        Rover rover = new Rover(position);
        Instruction instruction = Instruction.R;
        Position position1 = new Position(2, 3, Direction.S);
        Rover rover1 = new Rover(position1);
        Instruction instruction1 = Instruction.L;
        Position position2 = new Position(6, 0, Direction.N);
        Rover rover2 = new Rover(position2);
        //Act
        rover.getDirection(instruction);
        Position expected = new Position(5,4,Direction.S);
        rover1.getDirection(instruction);
        Position expected1 = new Position(2,3,Direction.W);
        rover2.getDirection(instruction1);
        Position expected2 = new Position(6,0,Direction.W);

        //Assert
        assertEquals(expected.getFacing(), rover.position.getFacing());
        assertEquals(expected1.getFacing(), rover1.position.getFacing());
        assertEquals(expected2.getFacing(), rover2.position.getFacing());
    }

    @Test
    @DisplayName("Remains null if the inputs are null")
    public void test_moveXPositionNullInputs(){
        //Arrange
        Position position = null;
        Rover rover = new Rover(position);
        Instruction instruction = null;
        //Act
        rover.moveXPosition(instruction);
        //Assert
        assertNull(rover.position);
    }

    @Test
    @DisplayName("Returns the same value if instruction is null")
    public void test_moveXPositionNullInstruction(){
        //Arrange
        Position position = new Position(2, 3, Direction.N);
        Rover rover = new Rover(position);
        Instruction instruction = null;
        //Act
        rover.moveXPosition(instruction);
        Position expected = new Position(2,3,Direction.N);
        //Assert
        assertEquals(expected.getX(), rover.position.getX());
    }

    @Test
    @DisplayName("Returns the same value if instruction is right or left")
    public void test_moveXPositionWrongInstruction(){
        //Arrange
        Position position = new Position(2, 3, Direction.N);
        Rover rover = new Rover(position);
        Instruction instruction = Instruction.R;
        //Act
        rover.moveXPosition(instruction);
        Position expected = new Position(2,3,Direction.N);
        //Assert
        assertEquals(expected.getX(), position.getX());
    }

    @Test
    @DisplayName("Returns the correct x value with a valid instruction")
    public void test_moveXPositionValidInstruction(){
        //Arrange
        Position position = new Position(2, 3, Direction.E);
        Rover rover = new Rover(position);
        Instruction instruction = Instruction.M;
        Position position1 = new Position(7, 2, Direction.W);
        Rover rover1 = new Rover(position1);
        Instruction instruction1 = Instruction.M;
        //Act
        rover.moveXPosition(instruction);
        Position expected = new Position(3,3,Direction.E);
        rover1.moveXPosition(instruction1);
        Position expected1 = new Position(6,2,Direction.W);
        //Assert
        assertEquals(expected.getX(), rover.position.getX());
        assertEquals(expected1.getX(), rover1.position.getX());
    }

    @Test
    @DisplayName("Returns the correct x value with consecutive instructions")
    public void test_moveXPositionConsecutiveInstruction(){
        //Arrange
        Position position = new Position(4, 7, Direction.E);
        Rover rover = new Rover(position);
        Instruction instruction = Instruction.M;
        //Act
        rover.moveXPosition(instruction);
        rover.moveXPosition(instruction);
        rover.moveXPosition(instruction);
        Position expected = new Position(7,7,Direction.E);
        //Assert
        assertEquals(expected.getX(), rover.position.getX());
    }

    @Test
    @DisplayName("Returns the same value if instruction is null")
    public void test_moveYPositionNullInstruction(){
        //Arrange
        Position position = new Position(2, 3, Direction.N);
        Rover rover = new Rover(position);
        Instruction instruction = null;
        //Act
        rover.moveYPosition(instruction);
        Position expected = new Position(2,3,Direction.N);
        //Assert
        assertEquals(expected.getY(), rover.position.getY());
    }

    @Test
    @DisplayName("Returns the same value if instruction is right or left")
    public void test_moveYPositionWrongInstruction(){
        //Arrange
        Position position = new Position(2, 3, Direction.N);
        Rover rover = new Rover(position);
        Instruction instruction = Instruction.R;
        //Act
        rover.moveYPosition(instruction);
        Position expected = new Position(2,3,Direction.N);
        //Assert
        assertEquals(expected.getY(), rover.position.getY());
    }

    @Test
    @DisplayName("Returns the correct y value with a valid instruction")
    public void test_moveYPositionValidInstruction(){
        //Arrange
        Position position = new Position(2, 3, Direction.N);
        Rover rover = new Rover(position);
        Instruction instruction = Instruction.M;
        Position position1 = new Position(7, 2, Direction.S);
        Rover rover1 = new Rover(position1);
        Instruction instruction1 = Instruction.M;
        //Act
        rover.moveYPosition(instruction);
        Position expected = new Position(2,4,Direction.E);
        rover1.moveYPosition(instruction1);
        Position expected1 = new Position(7,1,Direction.W);
        //Assert
        assertEquals(expected.getY(), rover.position.getY());
        assertEquals(expected1.getY(), rover1.position.getY());
    }

    @Test
    @DisplayName("Returns the correct y value with consecutive instructions")
    public void test_moveYPositionConsecutiveInstruction(){
        //Arrange
        Position position = new Position(4, 7, Direction.N);
        Rover rover = new Rover(position);
        Instruction instruction = Instruction.M;
        //Act
        rover.moveYPosition(instruction);
        rover.moveYPosition(instruction);
        rover.moveYPosition(instruction);
        Position expected = new Position(4,10,Direction.E);
        //Assert
        assertEquals(expected.getY(), rover.position.getY());
        assertEquals(expected.getX(), rover.position.getX());
    }




}