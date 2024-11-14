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
        String instructionInputValidLetters = instructionInput.replaceAll("[^rlmRLM]","").toUpperCase();
        if (instructionInputValidLetters.isEmpty()){
            return new ArrayList<>();
        }else {
            for (int i = 0; i < instructionInputValidLetters.length(); i++){
                if(instructionInputValidLetters.charAt(i) == 'R'){
                    instructionList.add(Instruction.R);
                }else if(instructionInputValidLetters.charAt(i) == 'L') {
                    instructionList.add(Instruction.L);
                }else{
                    instructionList.add(Instruction.M);
                }
            }
        }
        return instructionList;
    }
}
