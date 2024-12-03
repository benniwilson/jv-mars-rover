package Input;

import InputParsing.InstructionParser;
import InputParsing.PlateauSizeParser;
import InputParsing.PositionParser;
import Logic.Direction;
import Logic.Instruction;
import Logic.PlateauSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.deepEquals;

public class InputGetter {
Scanner scanner = new Scanner(System.in);
private int numOfRovers = 1;
private PlateauSize plateauSize;
private List<Integer> xPosition = new ArrayList<>();
private List<Integer> yPosition = new ArrayList<>();
private List<Direction> direction = new ArrayList<>();
private List<Instruction> instruction;

    public List<Integer> getxPosition() {
        return xPosition;
    }

    public List<Integer> getyPosition() {
        return yPosition;
    }

    public List<Direction> getDirection() {
        return direction;
    }

    public List<Instruction> getInstruction() {
        return instruction;
    }

    public int getNumOfRovers() {
        return numOfRovers;
    }

    public PlateauSize getPlateauSize(){
        return plateauSize;
    }


//This class will be responsible for getting the input from the terminal using Scanner.

    public void getInputPlateauSize(){
        boolean isValid = false;
        while(!isValid){
            try {
                System.out.println("Enter a plateau size (e.g 5 5): ");
                String plateauInput = scanner.nextLine();
                PlateauSizeParser plateauSizeParser = new PlateauSizeParser(plateauInput);
                int[][] size = plateauSizeParser.parsePlateauSize();
                plateauSize = new PlateauSize(size);
                if (deepEquals(plateauSize.getPlateauSize(), new int [0][0])){
                    throw new IllegalArgumentException("The plateau size is not in the correct format," +
                            " please try again...");
                }
                isValid = true;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void getNumberOfRovers(){
        boolean isValid = false;
        String numberOfRovers = "";
        while (!isValid){
            try {
                System.out.println("Enter the number of rovers: ");
                numberOfRovers = scanner.nextLine();
                if (!numberOfRovers.matches("[0-9]+")) {
                    throw new IllegalArgumentException("The number of rovers is invalid, please try again...");
                }
                isValid = true;
                numOfRovers = Integer.parseInt(numberOfRovers);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void getRoverStartingPosition(){
        String startingPosition = "";
        boolean isValid = false;
        PositionParser positionParser = new PositionParser();
        while (!isValid) {
            try {
                System.out.println("Enter the rover starting position (e.g 2 1 N): ");
                startingPosition = scanner.nextLine();
                int x = positionParser.parseXCoordinate(startingPosition);
                if (x == -1 || x > plateauSize.getPlateauSize()[0].length-1){
                    throw new IllegalArgumentException("The starting coordinates are invalid, " +
                            "please try again...");
                }
                int y = positionParser.parseYCoordinate(startingPosition);
                if (y == -1 || y > plateauSize.getPlateauSize()[1].length-1){
                    throw new IllegalArgumentException("The starting coordinates are invalid, " +
                            "please try again...");
                }
                Direction facing = positionParser.parseDirection(startingPosition);
                if (facing == null){
                    throw new IllegalArgumentException("The starting direction is invalid, please try again...");
                }
                xPosition.add(x);
                yPosition.add(y);
                direction.add(facing);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getRoverInstructions(){
        boolean isValid = false;
        InstructionParser instructionParser = new InstructionParser();
        while (!isValid){
            try{
                System.out.println("Enter the list of instructions for the Rover (e.g LMRLMML): ");
                String instructionInput = scanner.nextLine();
                instruction = instructionParser.parseInstruction(instructionInput);
                if (instruction == null){
                    throw new IllegalArgumentException("The instructions are not clear, please try again...");
                }
                isValid = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

