package day7;

import day2.OpCodeInput;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Amplifier {
    private int[] opcode;
    private int index;
    private boolean firstUsed;

    public int getIndex() {
        return index;
    }

    public Amplifier(String filePath) {
        opcode = OpCodeInput.getFromFile(new File(filePath));
        index = 0;
        firstUsed = false;
    }

    public int getNextOutput(int firstIn, int secIn) {
        int input = firstIn;
        List<Integer> outputs = new ArrayList<>();
        while (index < opcode.length) {
            if (firstUsed) {
                input = secIn;
            }
            int[] code = OpCodeParser.getCode(opcode, index);
            if (code[0] == 99) {
                System.exit(0);
            }

            int inc = OpCodeParser.getInc(opcode, code, index, input, outputs);
            if (code[0] == 4) {
                index += inc;
                return outputs.get(0);
            }
            if(code[0] == 3){
                input = secIn;
            }

            index += inc;
        }
        return outputs.get(0);
    }

    public int getNextOutput(int input) {
        List<Integer> outputs = new ArrayList<>();
        while (index < opcode.length) {
            int[] code = OpCodeParser.getCode(opcode, index);
            if (code[0] == 99) {
                throw new InputMismatchException();
            }

            int inc = OpCodeParser.getInc(opcode, code, index, input, outputs);
            if (code[0] == 4) {
                index += inc;
                return outputs.get(0);
            }

            index += inc;
        }
        return outputs.get(0);
    }
}
