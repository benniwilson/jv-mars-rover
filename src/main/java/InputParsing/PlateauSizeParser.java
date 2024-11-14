package InputParsing;

import java.util.Arrays;

public class PlateauSizeParser {
    private String plateauSizeInput;

    public PlateauSizeParser(String plateauSizeInput) {
        this.plateauSizeInput = plateauSizeInput;
    }

    public int[][] parsePlateauSize(){
        String plateauSizeValid = plateauSizeInput.replaceAll("[^0-9 ]","");
        String plateauSizeValidSingleSpace = plateauSizeValid.replaceAll("\\s+", " ");
        if (plateauSizeValidSingleSpace.equals(" ")){
            return new int[0][0];
        }else if (plateauSizeValidSingleSpace.startsWith(" ")){
            plateauSizeValidSingleSpace = plateauSizeValidSingleSpace.substring(1);
        }
        String[] plateauSizeValidSplit = plateauSizeValidSingleSpace.split(" ");
        if (plateauSizeValidSplit.length == 1){
            return new int[0][0];
        }else{
            return new int[Integer.parseInt(plateauSizeValidSplit[0])][Integer.parseInt(plateauSizeValidSplit[1])];
        }
    }
}
