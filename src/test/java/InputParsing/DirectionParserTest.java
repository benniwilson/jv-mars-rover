package InputParsing;

import Logic.Direction;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class DirectionParserTest extends TestCase {

    @Test
    @DisplayName("Direction parser returns null if there is no direction in the input")
    public void test_DirectionParserNoDirectionInput(){
        //Arrange
        DirectionParser directionParser = new DirectionParser();
        //Act
        Direction result = directionParser.parseDirection("");
        Direction expected = null;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Direction parser returns null if there is an invalid direction in the input")
    public void test_DirectionParserInvalidDirectionInput(){
        //Arrange
        DirectionParser directionParser = new DirectionParser();
        //Act
        Direction result = directionParser.parseDirection("3 1 F");
        Direction expected = null;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Direction parser returns the correct direction if the input is lower case in the input")
    public void test_DirectionParserLowerCaseDirectionInput(){
        //Arrange
        DirectionParser directionParser = new DirectionParser();
        //Act
        Direction result = directionParser.parseDirection("1 2 s");
        Direction expected = Direction.S;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Direction parser returns the correct direction if the input is valid")
    public void test_DirectionParserValidDirectionInput(){
        //Arrange
        DirectionParser directionParser = new DirectionParser();
        DirectionParser directionParser2 = new DirectionParser();
        DirectionParser directionParser3 = new DirectionParser();
        //Act
        Direction result = directionParser.parseDirection("0 0 E");
        Direction expected = Direction.E;
        Direction result2 = directionParser2.parseDirection("10 17 n");
        Direction expected2 = Direction.N;
        Direction result3 = directionParser3.parseDirection("2 7 W");
        Direction expected3 = Direction.W;
        //Assert
        assertEquals(expected, result);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @DisplayName("Direction parser returns the correct direction if the input has numerous direction inputs," +
            " including null if the direction doesn't contain N,E,S or W")
    public void test_DirectionParserMultipleDirectionInput(){
        //Arrange
        DirectionParser directionParser = new DirectionParser();
        DirectionParser directionParser2 = new DirectionParser();
        DirectionParser directionParser3 = new DirectionParser();
        //Act
        Direction result = directionParser.parseDirection("0 0 EFGT");
        Direction expected = Direction.E;
        Direction result2 = directionParser2.parseDirection("10 17 P L q X N");
        Direction expected2 = Direction.N;
        Direction result3 = directionParser3.parseDirection("2 7 POLRT");
        Direction expected3 = null;
        //Assert
        assertEquals(expected, result);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @DisplayName("Direction parser returns the correct direction, with input containing more whitespace")
    public void test_DirectionParserSpacedInput(){
        //Arrange
        DirectionParser directionParser = new DirectionParser();
        DirectionParser directionParser2 = new DirectionParser();
        DirectionParser directionParser3 = new DirectionParser();
        //Act
        Direction result = directionParser.parseDirection("4 6       N");
        Direction expected = Direction.N;
        Direction result2 = directionParser2.parseDirection("   10 134      MINw");
        Direction expected2 = Direction.N;
        Direction result3 = directionParser3.parseDirection("0 0 hff      p ee");
        Direction expected3 = Direction.E;
        //Assert
        assertEquals(expected, result);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @DisplayName("Direction parser returns the first direction if there are multiple directions in" +
            "the direction input")
    public void test_DirectionParserMultipleDirectionsInput(){
        //Arrange
        DirectionParser directionParser = new DirectionParser();
        DirectionParser directionParser2 = new DirectionParser();
        DirectionParser directionParser3 = new DirectionParser();
        //Act
        Direction result = directionParser.parseDirection("0 0 NESW");
        Direction expected = Direction.N;
        Direction result2 = directionParser2.parseDirection("1310 171 poloosNnEw");
        Direction expected2 = Direction.S;
        Direction result3 = directionParser3.parseDirection("2 7 lllqqWNS");
        Direction expected3 = Direction.W;
        //Assert
        assertEquals(expected, result);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }



}