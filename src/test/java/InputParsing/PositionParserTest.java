package InputParsing;

import Main.Direction;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import javax.management.DescriptorRead;

public class PositionParserTest extends TestCase {

    @Test
    @DisplayName("Parse X coordinate returns 0 when passed no input")
    public void test_parseXCoordinateNoInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("");
        //Act
        int result = positionParser.parseXCoordinate();
        int expected = 0;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse X coordinate returns correct value when passed input in wrong format")
    public void test_parseXCoordinateWrongFormatInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("NORTH 88 99");
        //Act
        int result = positionParser.parseXCoordinate();
        int expected = 88;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse X coordinate returns the correct value when passed a valid input")
    public void test_parseXCoordinateValidInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("2 8 N");
        //Act
        int result = positionParser.parseXCoordinate();
        int expected = 2;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse X coordinate returns the correct value with whitespace before")
    public void test_parseXCoordinateSpacedInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("     23 93 E");
        //Act
        int result = positionParser.parseXCoordinate();
        int expected = 23;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse Y coordinate returns 0 when passed no input")
    public void test_parseYCoordinateNoInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("");
        //Act
        int result = positionParser.parseYCoordinate();
        int expected = 0;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse Y coordinate returns correct value when passed input in wrong format")
    public void test_parseYCoordinateWrongFormatInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("NORTH 88 99");
        //Act
        int result = positionParser.parseYCoordinate();
        int expected = 99;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse Y coordinate returns the correct value when passed a valid input")
    public void test_parseYCoordinateValidInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("2 8 N");
        //Act
        int result = positionParser.parseYCoordinate();
        int expected = 8;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse Y coordinate returns the correct value with whitespace before and during")
    public void test_parseYCoordinateSpacedInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("     23       93 E");
        //Act
        int result = positionParser.parseYCoordinate();
        int expected = 93;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse direction returns 0 when passed no input")
    public void test_parseDirectionNoInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("");
        //Act
        Direction result = positionParser.parseDirection();
        Direction expected = null;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse direction returns correct value when passed input in wrong format")
    public void test_parseDirectionWrongFormatInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("NORTH 88 99");
        //Act
        Direction result = positionParser.parseDirection();
        Direction expected = Direction.N;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse direction returns the correct value when passed a valid input")
    public void test_parseDirectionValidInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("2 8 N");
        //Act
        Direction result = positionParser.parseDirection();
        Direction expected = Direction.N;
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Parse direction returns the correct value with whitespace before and during")
    public void test_parseDirectionSpacedInput(){
        //Arrange
        PositionParser positionParser = new PositionParser("     23       93 E");
        //Act
        Direction result = positionParser.parseDirection();
        Direction expected = Direction.E;
        //Assert
        assertEquals(expected, result);
    }

}