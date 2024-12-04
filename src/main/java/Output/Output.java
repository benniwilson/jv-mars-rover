package Output;

import Logic.PlateauSize;
import Logic.Rover;

import java.util.Arrays;
import java.util.List;

public class Output {
    //Class will be responsible for printing out the plateau and the rovers' position on that plateau.
    //Firstly will sort out the number of rovers that we can choose.
    public static void printEndPlateau(List<Rover> roverList, PlateauSize plateauSize){
        int x;
        int y;
        for (int i = 0; i < roverList.size(); i++){
            x = plateauSize.getPlateauSize()[0].length;
            plateauSize.getPlateauSize()
                    [5-roverList.get(i).getPosition().getY()]
                    [roverList.get(i).getPosition().getX()] = i+1;
        }
        System.out.println("...THE FINAL POSITION OF THE ROVER(S) ON THE PLATEAU...");
        System.out.println(Arrays.deepToString(plateauSize.getPlateauSize()).replace("], ", "]\n"));
    }
}
