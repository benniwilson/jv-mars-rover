package InputParsing;

import Main.Instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {
    private String instructionInput;

    public InstructionParser(String instructionInput) {
        this.instructionInput = instructionInput;
    }

    public List<Instruction> parseInstruction(){
        List<Instruction> instructionList = new ArrayList<>();
        String directionInputValidLetters = instructionInput.replaceAll("[^rlmRLM]","").toUpperCase();
        if (directionInputValidLetters.isEmpty()){
            return new ArrayList<>();
        }else {
            for (int i = 0; i < directionInputValidLetters.length(); i++){
                if(directionInputValidLetters.charAt(i) == 'R'){
                    instructionList.add(Instruction.R);
                }else if(directionInputValidLetters.charAt(i) == 'L') {
                    instructionList.add(Instruction.L);
                }else{
                    instructionList.add(Instruction.M);
                }
            }
        }
        return instructionList;
    }
}
