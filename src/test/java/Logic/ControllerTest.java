package Logic;

import Input.Input;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class ControllerTest extends TestCase {

    @Test
    @DisplayName("Returns false if passed an empty list of strings as input")
    public void test_controllerMovementEmptyString(){
        //Arrange
        Controller controller = new Controller();
        List<String> list = List.of();
        //Assert
        assertFalse(controller.movement(list));
    }

    @Test
    @DisplayName("Returns false if passed a list of strings with a wrong number of arguments")
    public void test_controllerMovementWrongNoArgumentsString(){
        //Arrange
        Controller controller = new Controller();
        List<String> list = List.of("5 5", "mlmlllrlm");
        //Assert
        assertFalse(controller.movement(list));
    }

    @Test
    @DisplayName("Returns false if the plateau size input is invalid")
    public void test_controllerMovementWrongInvalidPlateauSizeString(){
        //Arrange
        Controller controller = new Controller();
        List<String> list = List.of("5", "1 2 N", "MMLLRMLM");
        //Assert
        assertFalse(controller.movement(list));
    }

    @Test
    @DisplayName("Returns false if the initial position input is invalid")
    public void test_controllerMovementWrongInvalidInitialPositionString(){
        //Arrange
        Controller controller = new Controller();
        List<String> list = List.of("5", "1 2", "MMLLRMLM");
        //Assert
        assertFalse(controller.movement(list));
    }

    @Test
    @DisplayName("Returns false if the instruction input is invalid")
    public void test_controllerMovementWrongInvalidInstructionString(){
        //Arrange
        Controller controller = new Controller();
        List<String> list = List.of("5", "1 2 S", "loloooa");
        //Assert
        assertFalse(controller.movement(list));
    }

    @Test
    @DisplayName("Returns true if the input is valid and returns the correct rover position")
    public void test_controllerMovementValidInput(){
        //Arrange
        Controller controller = new Controller();
        List<String> list = List.of("5 5", "1 2 S", "MMLMMLMMMM");
        //Assert
        assertTrue(controller.movement(list));
        assertEquals(controller.rovers.get(0).position.getX(), 3);
        assertEquals(controller.rovers.get(0).position.getY(), 4);
        assertEquals(controller.rovers.get(0).position.getFacing(), Direction.N);
    }

    @Test
    @DisplayName("Returns true if the input is valid and returns the correct rover position" +
            "with the rover trying to move at the edge")
    public void test_controllerMovementValidInputAtEdge(){
        //Arrange
        Controller controller = new Controller();
        List<String> list = List.of("5 5", "4 2 E", "MMRMRRMML");
        //Assert
        assertTrue(controller.movement(list));
        assertEquals(controller.rovers.getFirst().position.getX(), 5);
        assertEquals(controller.rovers.getFirst().position.getY(), 3);
        assertEquals(controller.rovers.getFirst().position.getFacing(), Direction.W);
    }

    @Test
    @DisplayName("Returns true if the input is valid and returns the correct rover position" +
            "with multiple rovers")
    public void test_controllerMovementMultipleRovers(){
        //Arrange
        Controller controller = new Controller();
        List<String> list = List.of("5 5", "4 2 E", "MMRMRRMML","0 2 E", "LLMLMMRRMRMM"); //1 2 E
        //Assert
        assertTrue(controller.movement(list));
        assertEquals(controller.rovers.get(0).position.getX(), 5);
        assertEquals(controller.rovers.get(0).position.getY(), 3);
        assertEquals(controller.rovers.get(0).position.getFacing(), Direction.W);
        assertEquals(controller.rovers.get(1).position.getX(), 2);
        assertEquals(controller.rovers.get(1).position.getY(), 1);
        assertEquals(controller.rovers.get(1).position.getFacing(), Direction.E);
    }



}