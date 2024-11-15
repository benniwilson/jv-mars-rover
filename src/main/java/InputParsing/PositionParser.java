package InputParsing;

import Logic.Direction;

public class PositionParser {

    public String[] splitNumbers(String positionInput){
        String positionInputNumbers = positionInput.replaceAll("[^0-9 ]","");
        positionInputNumbers = positionInputNumbers.replaceAll("\\s+"," ");
        return positionInputNumbers.split(" ");
    }

    public int parseXCoordinate(String positionInput){
        if (positionInput.isEmpty()){
            return 0;
        }
        String[] positionInputArray = splitNumbers(positionInput);
        if (positionInputArray[0].isEmpty()){
            return Integer.parseInt(positionInputArray[1]);
        }else{
            return Integer.parseInt(positionInputArray[0]);
        }
    }

    public int parseYCoordinate(String positionInput){
        if(positionInput.isEmpty()){
            return 0;
        }
        String[] positionInputArray = splitNumbers(positionInput);
        if(positionInputArray[0].isEmpty()){
            return Integer.parseInt(positionInputArray[2]);
        }else{
            return Integer.parseInt(positionInputArray[1]);
        }
    }

    public Direction parseDirection(String positionInput){
        DirectionParser directionParser = new DirectionParser();
        return directionParser.parseDirection(positionInput);
    }
}
