package Logic;

import Input.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    PlateauSize plateauSize;
    List<Rover> rovers = new ArrayList<>();
    int numOfRovers;


   public boolean movement(List<String> stringList){
       Input input = new Input(stringList);
       boolean inputValidation = input.inputValidator();
        if(!inputValidation){
            return false;
        }
        //Naming all variables needed for the program.
        plateauSize = new PlateauSize(input.getPlateauSizeParser().parsePlateauSize());
        int x;
        int y;
        Direction facing;
        Position position;
        numOfRovers = (stringList.size()-1)/2;

        for (int i = 0; i < numOfRovers; i++){
            x = input.getPositionParser().parseXCoordinate(input.getPositionParserStrings().get(i));
            y = input.getPositionParser().parseYCoordinate(input.getPositionParserStrings().get(i));
            facing = input.getPositionParser().parseDirection(input.getPositionParserStrings().get(i));
            position = new Position(x, y, facing);
            Rover rover = new Rover(position);
            rovers.add(rover);

            for (Instruction instruction : input.getInstructionParser().parseInstruction(input.getInstructionParserStrings().get(i))){
                if (instruction == Instruction.M && plateauSize.isMovementAllowed(rover.position, instruction) &&
                        (rover.position.getFacing() == Direction.E || rover.position.getFacing() == Direction.W)){
                    rover.moveXPosition(instruction);
                }else if (instruction == Instruction.M && plateauSize.isMovementAllowed(rover.position, instruction)
                && (rover.position.getFacing() == Direction.N || rover.position.getFacing() == Direction.S)){
                    rover.moveYPosition(instruction);
                }else if (instruction == Instruction.M && !plateauSize.isMovementAllowed(rover.position, instruction)){
                    System.out.println("The rover is at the edge of the plateau be careful...");
                }else if (instruction == Instruction.R || instruction == Instruction.L){
                    rover.getDirection(instruction);
                }
            }
            System.out.println(rover.position.getX() + " " + rover.position.getY() + " " + rover.position.getFacing());
        }
        System.out.println("Mission completed successfully...");
        return true;
    }
}
