package InputParsing;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlateauSizeParserTest extends TestCase {

    @Test
    @DisplayName("Returns an empty 2D array with no input")
    public void test_PlateauSizeParserNoInput(){
        //Arrange
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser("");
        //Act
        int[][] result = plateauSizeParser.parsePlateauSize();
        int[][] expected = new int[0][0];
        //Assert
        assertArrayEquals(result, expected);
    }

    @Test
    @DisplayName("Returns an empty 2D array with invalid input")
    public void test_PlateauSizeParserInvalidInput(){
        //Arrange
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser("Hello World");
        //Act
        int[][] result = plateauSizeParser.parsePlateauSize();
        int[][] expected = new int[0][0];
        //Assert
        assertArrayEquals(result, expected);
    }

    @Test
    @DisplayName("Returns an empty 2D array only one input number in input string")
    public void test_PlateauSizeParserOneNumberInput(){
        //Arrange
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser("12");
        //Act
        int[][] result = plateauSizeParser.parsePlateauSize();
        int[][] expected = new int[0][0];
        //Assert
        assertArrayEquals(result, expected);
    }

    @Test
    @DisplayName("Returns correct array with valid input")
    public void test_PlateauSizeParserValidInput(){
        //Arrange
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser("2 2");
        //Act
        int[][] result = plateauSizeParser.parsePlateauSize();
        int[][] expected = new int[2][2];
        //Assert
        assertArrayEquals(result, expected);
    }

    @Test
    @DisplayName("Returns a correct array with input with multiple spaces")
    public void test_PlateauSizeParserWhitespaceInput(){
        //Arrange
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser("10      9");
        //Act
        int[][] result = plateauSizeParser.parsePlateauSize();
        int[][] expected = new int[10][9];
        //Assert
        assertArrayEquals(result, expected);
    }

    @Test
    @DisplayName("Returns a correct array with input that starts with a space")
    public void test_PlateauSizeParserStartsWithSpaceInput(){
        //Arrange
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser(" 6 6");
        //Act
        int[][] result = plateauSizeParser.parsePlateauSize();
        int[][] expected = new int[6][6];
        //Assert
        assertArrayEquals(result, expected);
    }

    @Test
    @DisplayName("Returns the correct array with a harder input i.e large number/uneven numbers")
    public void test_PlateauSizeParserValidHardInput(){
        //Arrange
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser("123 67");
        //Act
        int[][] result = plateauSizeParser.parsePlateauSize();
        int[][] expected = new int[123][67];
        //Assert
        assertArrayEquals(result, expected);
    }
}