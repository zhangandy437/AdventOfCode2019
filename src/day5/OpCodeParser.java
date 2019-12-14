package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class OpCodeParser {
    public static int parse(int[] opcode, int input) {
        boolean hasEnded = false;
        int i = 0;

        List<Integer> inputs = new ArrayList<Integer>();
        List<Integer> outputs = new ArrayList<Integer>();
        // Immediate vs Parameterized
        while (i < opcode.length && !hasEnded) {
            int increase = 4;
            int[] code = getCode(i, opcode);
            System.out.println(Arrays.toString(code));
            if (code[0] == 99) {
                hasEnded = true;
            } else if (code[0] == 1) {
                opcode[code[3]] = code[1] + code[2];
            } else if (code[0] == 2) {
                opcode[code[3]] = code[1] * code[2];
            } else if (code[0] == 3) {
                // Input
                increase = 2;
                opcode[code[1]] = input;
            } else if (code[0] == 4) {
                // Output
                increase = 2;
                System.out.print(code[1]);
            } else {
                throw new InputMismatchException("Position i was " + code[0]);
            }
            i += increase;
            System.out.println(Arrays.toString(opcode));
        }
//        inputs.forEach(j -> System.out.print(j + " "));
        System.out.println("outputs");
//        outputs.forEach(j -> System.out.print(j + " "));
        return opcode[0];
    }

    public static int[] getCode(int index, int[] opcode){
        int[] code = new int[4];
        int num = opcode[index];
        code[0] = num % 100;
        num /= 100;
        code[1] = num % 10;
        num /= 10;
        code[2] = num % 10;
        num /= 10;
        code[3] = num % 10;

        if(code[0] == 3 || code[0] == 4){
            code[1] = opcode[index + 1];
            return code;
        }

        for(int i = 1; i < code.length - 1; i++){
            if(code[i] == 1){
                code[i] = opcode[i + index];
            } else if(code[i] == 0){
                code[i] = opcode[opcode[i + index]];
            }
        }
        code[3] = opcode[index + 3];
        System.out.println("Done");
        return code;
    }
}