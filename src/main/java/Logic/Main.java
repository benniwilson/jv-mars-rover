package Logic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listInput = List.of("5 5","2 2 N","LMLMLMLMM","4 3 E","MMRMMRMRRM", "2 1 S", "MRMRMLMLM");
        Controller controller = new Controller();
        controller.movement(listInput);
    }
}
