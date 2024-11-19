package Input;

import InputParsing.DirectionParser;
import InputParsing.InstructionParser;
import InputParsing.PlateauSizeParser;
import InputParsing.PositionParser;
import Logic.Instruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.deepEquals;

public class Input {
    //The purpose of the Input class is to allocate the correct strings to each parser class.
    PlateauSizeParser plateauSizeParser;
    PositionParser positionParser;
    List<String> positionParserStrings = new ArrayList<>();
    InstructionParser instructionParser;
    List<String> instructionParserStrings = new ArrayList<>();
    int numberOfRovers;


    public int getNumberOfRovers() {
        return numberOfRovers;
    }

    public List<String> getPositionParserStrings() {
        return positionParserStrings;
    }

    public List<String> getInstructionParserStrings() {
        return instructionParserStrings;
    }

    public PlateauSizeParser getPlateauSizeParser() {
        return plateauSizeParser;
    }

    public PositionParser getPositionParser() {
        return positionParser;
    }

    public InstructionParser getInstructionParser() {
        return instructionParser;
    }

    public boolean inputValidator(List<String> input){
        //inputValidator validates that the input is suitable for use, using its own logic in terms of
        //the input size and the parser classes logic for their own individual inputs.
        if (input.size() < 3 || input.size() % 2 == 0){
            return false;
        }
        plateauSizeParser = new PlateauSizeParser(input.get(0));
        if (deepEquals(plateauSizeParser.parsePlateauSize(), new int[0][0])){
            System.out.println("The plateau has no size, try again...");
            return false;
        }
        instructionParser =  new InstructionParser();
        positionParser = new PositionParser();
        numberOfRovers = (input.size()-1)/2;
        for (int i = 1; i < input.size(); i++) {
            if (i % 2 == 0 && instructionParser.parseInstruction(input.get(i)) == null) {
                System.out.println("The instructions for the rover are incomplete, try again...");
                return false;
            } else if (i % 2 == 0) {
                instructionParserStrings.add(input.get(i));
            } else if (positionParser.parseDirection(input.get(i)) == null ||
                    positionParser.parseXCoordinate(input.get(i)) == -1 ||
                    positionParser.parseYCoordinate(input.get(i)) == -1) {
                System.out.println("The starting position for the rover is incorrect, try again...");
                return false;
            } else {
                positionParserStrings.add(input.get(i));
            }
        }
        return true;
    }
}
