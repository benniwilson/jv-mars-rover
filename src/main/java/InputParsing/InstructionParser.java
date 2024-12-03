package InputParsing;

import Logic.Instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {

    public Instruction parseInstruction(String instructionInput){
        Instruction instruction;
        String instructionInputValidLetters = instructionInput.replaceAll("[^rlmRLM]","").toUpperCase();
        if (instructionInputValidLetters.isEmpty()){
            return null;
        }else if(instructionInputValidLetters.charAt(0) == 'R'){
                    instruction = Instruction.R;
        }else if(instructionInputValidLetters.charAt(0) == 'L'){
                    instruction = Instruction.L;
        }else if(instructionInputValidLetters.charAt(0) == 'M'){
                    instruction = Instruction.M;
        }else{
            return null;
        }
        return instruction;
    }
}
