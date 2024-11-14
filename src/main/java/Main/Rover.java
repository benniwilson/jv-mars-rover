package Main;

import java.util.List;

public class Rover {
    private List<Instruction> instructions;

    public Direction getDirection(Direction direction, Instruction instruction){
        if (direction == null || instruction == null){
            return null;
        }
        int value = direction.ordinal();
        if (instruction == Instruction.M){
            return direction;
        }else if(instruction == Instruction.R && direction == Direction.W){
            return Direction.N;
        }else if(instruction == Instruction.R){
            return Direction.values()[value+1];
        }else if (instruction == Instruction.L && direction == Direction.N){
            return Direction.W;
        }else{
            return Direction.values()[value-1];
        }
    }
    public int getXPosition(Position currentPosition, Instruction instruction){

    }

    public int getYPosition(Position currentPosition, Instruction instruction){

    }
}
