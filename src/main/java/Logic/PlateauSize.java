package Main;

public class PlateauSize {
    int[][] plateauSize;

    public PlateauSize(int[][] plateauSize) {
        this.plateauSize = plateauSize;
    }

    public boolean isMovementAllowed(Position position, Instruction instruction){
        if (position == null || instruction == null){
            return false;
        }
        int x = plateauSize[0].length;
        int y = plateauSize[1].length;
        if (position.getFacing() == Direction.E && position.getX() == x){
            return false;
        }else if (position.getFacing() == Direction.W && position.getX() == 0){
            return false;
        }else if (position.getFacing() == Direction.N && position.getY() == y){
            return false;
        }else if (position.getFacing() == Direction.S && position.getY() == 0){
            return false;
        }
        return true;
    }

}
