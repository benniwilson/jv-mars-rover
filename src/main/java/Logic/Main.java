package Logic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listInput = List.of("5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM");
        Controller controller = new Controller();
        controller.movement(listInput);
    }
}
