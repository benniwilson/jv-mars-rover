package Logic;

public class PlateauSize {
    int[][] plateauSize = new int[6][6];

    public PlateauSize() {}

    public int[][] getPlateauSize() {
        return plateauSize;
    }

    public boolean isMovementAllowed(Position position, Instruction instruction){
        if (position == null || instruction == null){
            return false;
        }
        int x = plateauSize[0].length-1;
        int y = plateauSize[1].length-1;
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
