package Input;

import InputParsing.DirectionParser;
import InputParsing.InstructionParser;
import InputParsing.PlateauSizeParser;
import InputParsing.PositionParser;
import Logic.Direction;
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
    List<String> input;

    public Input(List<String> input) {
        this.input = input;
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

    public boolean inputValidator() {
        if (input.size() < 3 || input.size() % 2 == 0){
            return false;
        }
        boolean isPlateauSizeValid = plateauSizeInputValidator();
        if (!isPlateauSizeValid){
            return false;
        }
        boolean isPositionValid = positionParserInputValidator();
        if (!isPositionValid){
            return false;
        }
        boolean isInstructionValid = instructionParserInputValidator();
        if (!isInstructionValid){
            return false;
        }
        return true;
    }

    public boolean plateauSizeInputValidator(){
        plateauSizeParser = new PlateauSizeParser(input.getFirst());
        try {
            int[][] plateauSize = plateauSizeParser.parsePlateauSize();
            if (deepEquals(plateauSize, new int[0][0])){
                throw new IllegalArgumentException("The plateau size is invalid, please try another input...");
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean positionParserInputValidator(){
        int y;
        int x;
        Direction direction;
        plateauSizeParser = new PlateauSizeParser(input.getFirst());
        int xMax = plateauSizeParser.parsePlateauSize()[0].length-1;
        int yMax = plateauSizeParser.parsePlateauSize()[1].length-1;
        positionParser = new PositionParser();
        for (int i = 1; i < input.size(); i++){
            if (i % 2 != 0){
                try {
                y = positionParser.parseYCoordinate(input.get(i));
                x = positionParser.parseXCoordinate(input.get(i));
                direction = positionParser.parseDirection(input.get(i));
                if (y == -1 || x == -1 || direction == null){
                    throw new IllegalArgumentException("The rover starting position is invalid, please " +
                            "try another input...");
                }else if (x > xMax){
                    throw new IllegalArgumentException("The starting x coordinate is greater than the size of the" +
                            " plateau, please try another input...");
                }else if(y > yMax){
                    throw new IllegalArgumentException("The starting y coordinate is greater than the size of the" +
                            " plateau, please try another input...");
                }
                positionParserStrings.add(input.get(i));
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    return false;
            }
        }
        }
        return true;
    }

    public boolean instructionParserInputValidator(){
        instructionParser = new InstructionParser();
        for (int i = 1; i < input.size(); i++){
            if (i % 2 == 0){
                try{
                    List<Instruction> instructions = instructionParser.parseInstruction(input.get(i));
                    if (instructions == null){
                        throw new IllegalArgumentException("The instructions passed to the rover are invalid" +
                                ", please try again...");
                    }
                    instructionParserStrings.add(input.get(i));
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }
        return true;
    }
}
