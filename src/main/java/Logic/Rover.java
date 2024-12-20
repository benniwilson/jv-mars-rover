package Logic;

public class Rover {
    Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void getDirection(Instruction instruction){
        int value = 0;
        if (instruction == null || position == null){
            System.out.println("Current position is unknown...");
        }else if (instruction == Instruction.R && position.getFacing() == Direction.W){
            position.setFacing(Direction.N);
        }else if(instruction == Instruction.R){
            value = position.getFacing().ordinal();
            position.setFacing(position.getFacing().values()[value+1]);
        }else if (instruction == Instruction.L && position.getFacing() == Direction.N){
            position.setFacing(Direction.W);
        }else if (instruction == Instruction.L){
            value = position.getFacing().ordinal();
            position.setFacing(position.getFacing().values()[value-1]);
        }
    }

    public void moveXPosition(Instruction instruction){
        if (position == null){
            System.out.println("Current position is unknown...");
        }else if (instruction == null || instruction != Instruction.M) {
            position.setX(position.getX());
        }else if (position.getFacing() == Direction.E){
            position.setX(position.getX()+1);
        }else if (position.getFacing() == Direction.W){
            position.setX(position.getX()-1);
        }
    }

    public void moveYPosition(Instruction instruction){
        if (position == null){
            System.out.println("Current position is unknown...");
        }else if (instruction == null || instruction != Instruction.M){
            position.setY(position.getY());
        }else if (position.getFacing() == Direction.N){
            position.setY(position.getY()+1);
        }else if(position.getFacing() == Direction.S){
            position.setY(position.getY()-1);
        }
    }
}
