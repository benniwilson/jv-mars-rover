package InputParsing;
import Logic.Direction;

public class DirectionParser {


    public Direction parseDirection(String directionInput){
        //directionInput consists of numbers and letters,
        //we only care about letters for direction so get rid of the
        //numbers. Then see if the directionInput size is 0,1 or more than 1
        //and deal appropriately.
        String directionInputLetters = directionInput.replaceAll("[^neswNESW]","").toUpperCase();
        if (directionInputLetters.isEmpty()){
            return null;
        }else{
            switch(directionInputLetters.charAt(0)){
                case 'N':
                    return Direction.N;
                case 'E':
                    return Direction.E;
                case 'S':
                    return Direction.S;
                case 'W':
                    return Direction.W;
            }
        }
        return null;
    }
}
