package Logic;

import Input.InputGetter;
import InputParsing.PlateauSizeParser;
import Output.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    List<Rover> rovers = new ArrayList<>();
    InputGetter inputGetter = new InputGetter();

    public void getInput(){;
        inputGetter.getInputPlateauSize();
        inputGetter.getNumberOfRovers();
    }

   public void roverMovement(){
        getInput();
        int x;
        int y;
        Direction facing;
        for (int i = 0; i < inputGetter.getNumOfRovers(); i++){
            inputGetter.getRoverStartingPosition();
            inputGetter.getRoverInstructions();
            x = inputGetter.getxPosition().get(i);
            y = inputGetter.getyPosition().get(i);
            facing = inputGetter.getDirection().get(i);
            Position startingPosition = new Position(x,y,facing);
            Rover rover = new Rover(startingPosition);
            rovers.add(rover);
            for (Instruction instruction : inputGetter.getInstruction()){
                if (horizontalMovement(instruction, rover.position)){
                    rover.moveXPosition(instruction);
                }else if (verticalMovement(instruction, rover.position)){
                    rover.moveYPosition(instruction);
                }else if (rotation(instruction)){
                    rover.getDirection(instruction);
                }else if (!horizontalMovement(instruction, rover.position) || !verticalMovement(instruction, rover.position)){
                    System.out.println("The rover is at the edge of the plateau, be careful...");
                }
            }
            int p = i+1;
            System.out.println("ROVER " + p + ": " + rover.position.getX() + " " + rover.position.getY() + " " + rover.position.getFacing());
        }
       Output.printEndPlateau(rovers, inputGetter.getPlateauSize());
    }

    public boolean horizontalMovement(Instruction instruction, Position position){
        return (instruction == Instruction.M && inputGetter.getPlateauSize().isMovementAllowed(position, instruction)
                && (position.getFacing() == Direction.E || position.getFacing() == Direction.W));
    }

    public boolean verticalMovement(Instruction instruction, Position position){
        return (instruction == Instruction.M && inputGetter.getPlateauSize().isMovementAllowed(position, instruction)
                && (position.getFacing() == Direction.N || position.getFacing() == Direction.S));
    }

    public boolean rotation(Instruction instruction){
        return (instruction == Instruction.R || instruction == Instruction.L);
    }
}
