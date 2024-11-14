package InputParsing;

import Main.Direction;

import java.util.Arrays;
import java.util.Objects;

public class PositionParser {
    private String positionInput;

    public PositionParser(String positionInput) {
        this.positionInput = positionInput;
    }

    public String[] splitNumbers(){
        String positionInputNumbers = positionInput.replaceAll("[^0-9 ]","");
        positionInputNumbers = positionInputNumbers.replaceAll("\\s+"," ");
        return positionInputNumbers.split(" ");
    }

    public int parseXCoordinate(){
        if (positionInput.isEmpty()){
            return 0;
        }
        String[] positionInputArray = splitNumbers();
        if (positionInputArray[0].isEmpty()){
            return Integer.parseInt(positionInputArray[1]);
        }else{
            return Integer.parseInt(positionInputArray[0]);
        }
    }

    public int parseYCoordinate(){
        if(positionInput.isEmpty()){
            return 0;
        }
        String[] positionInputArray = splitNumbers();
        if(positionInputArray[0].isEmpty()){
            return Integer.parseInt(positionInputArray[2]);
        }else{
            return Integer.parseInt(positionInputArray[1]);
        }
    }

    public Direction parseDirection(){
        DirectionParser directionParser = new DirectionParser(positionInput);
        return directionParser.parseDirection();
    }
}
