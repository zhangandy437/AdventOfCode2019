package day7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class OpCodeParser {

    private static boolean firstUsed;

    public static int parse(int[] opcode, int firstIn, int secIn) {
        firstUsed = false;

        int input = firstIn;
        int i = 0;

        List<Integer> outputs = new ArrayList<>();

        while (i < opcode.length) {
            if(firstUsed){
                input = secIn;
            }
            int[] code = getCode(opcode, i);
            if (code[0] == 99) {
                return outputs.get(0);
            }
            int inc = getInc(opcode, code, i, input, outputs);


            i += inc;
        }

        return outputs.get(0);
    }

    public static int getInc(int[] opcode, int[] code, int index, int input, List<Integer> outputs) {
        return switch (code[0]) {
            case 1, 2 -> addMultiply(opcode, code);
            case 3, 4 -> inOut(opcode, code, input, outputs);
            case 5, 6 -> jump(code, index);
            case 7, 8 -> lessOrEqual(opcode, code);
            default -> throw new InputMismatchException("Position i was " + code[0]);
        };
    }

    private static int addMultiply(int[] opcode, int[] code) {
        opcode[code[3]] = code[0] == 1 ? code[1] + code[2] : code[1] * code[2];
        return 4;
    }

    private static int inOut(int[] opcode, int[] code, int input, List<Integer> outputs) {
        if (code[0] == 3) {
            opcode[code[1]] = input;
            firstUsed = true;
        } else {
            outputs.add(code[1]);
        }
        return 2;
    }

    private static int jump(int[] code, int index) {
        return code[0] == 5 ?
                code[1] != 0 ? code[2] - index : 3 :
                code[1] == 0 ? code[2] - index : 3;
    }

    private static int lessOrEqual(int[] opcode, int[] code) {
        opcode[code[3]] = code[0] == 7 ?
                code[1] < code[2] ? 1 : 0 :
                code[1] == code[2] ? 1 : 0;
        return 4;
    }

    public static int[] getCode(int[] opcode, int index) {
        int num = opcode[index];
        return getValues(switch (num % 100) {
            case 3    -> new int[]{3, 1};
            case 4    -> new int[]{4, 0};
            case 5, 6 -> new int[]{num % 100, num / 100 % 10, num / 1000 % 10};
            case 99   -> new int[]{99};
            default   -> new int[]{num % 100, num / 100 % 10, num / 1000 % 10, 1};
        }, opcode, index);
    }

    private static int[] getValues(int[] code, int[] opcode, int index) {
        for (int i = 1; i < code.length; i++) {
            code[i] = opcode[code[i] == 1 ? index + i : opcode[index + i]];
        }
        return code;
    }
}