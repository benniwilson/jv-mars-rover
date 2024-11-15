package InputParsing;

import Logic.Instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {

    public List<Instruction> parseInstruction(String instructionInput){
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
