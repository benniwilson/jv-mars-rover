package Main;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class PlateauSizeTest extends TestCase {

    @Test
    @DisplayName("Returns false when the inputs are null")
    public void test_isMovementAllowedNullInputs(){
        //Arrange
        PlateauSize plateauSize = new PlateauSize(new int[5][5]);
        Position position = null;
        Instruction instruction = null;
        //Assert
        assertFalse(plateauSize.isMovementAllowed(position,instruction));
    }

    @Test
    @DisplayName("Returns true for rotation movement in the plateau")
    public void test_isMovementAllowedRotation(){
        //Arrange
        PlateauSize plateauSize = new PlateauSize(new int[5][5]);
        Position position = new Position(3,4,Direction.E);
        Instruction instruction = Instruction.R;
        //Assert
        assertTrue(plateauSize.isMovementAllowed(position,instruction));
    }

    @Test
    @DisplayName("Returns true for valid movement in the plateau")
    public void test_isMovementAllowedValid(){
        //Arrange
        PlateauSize plateauSize = new PlateauSize(new int[5][5]);
        Position position = new Position(3,4,Direction.E);
        Instruction instruction = Instruction.M;
        //Assert
        assertTrue(plateauSize.isMovementAllowed(position,instruction));
    }

    @Test
    @DisplayName("Returns false for movement that would take the rover off the edge of the plateau")
    public void test_isMovementAllowedEdge(){
        //Arrange
        PlateauSize plateauSize = new PlateauSize(new int[5][5]);
        Position position = new Position(3,0,Direction.S);
        Instruction instruction = Instruction.M;
        //Assert
        assertFalse(plateauSize.isMovementAllowed(position,instruction));
    }



}