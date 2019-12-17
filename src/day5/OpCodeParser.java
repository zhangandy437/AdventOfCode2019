package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class OpCodeParser {
    public static String parse(int[] opcode, int input) {
//        day2.OpCodeParser.error1202(opcode, 12, 2);
        int i = 0;
        List<Integer> outputs = new ArrayList<>();

        while (i < opcode.length) {
            System.out.println(Arrays.toString(opcode));
            int increase = 4;
            int[] code = getCode(opcode[i]);
            getValues(code, opcode, i);
            if (code[0] == 99) {
                return outputs.toString();
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
                outputs.add(code[1]);
            } else if (code[0] == 5) {
                // increase by 2
                if(code[1] != 0){
                    increase = 0;
                    i = code[2];
                } else {
                    increase = 3;
                }
            } else if (code[0] == 6) {
                if(code[1] == 0){
                    increase = 0;
                    i = code[2];
                } else {
                    increase = 3;
                }
            } else if (code[0] == 7) {
                // don't change increase
                if(code[1] < code[2]){
                    opcode[code[3]] = 1;
                } else {
                    opcode[code[3]] = 0;
                }
            } else if (code[0] == 8) {
                // don't change increase
                if(code[1] == code[2]){
                    opcode[code[3]] = 1;
                } else {
                    opcode[code[3]] = 0;
                }
            } else {
                throw new InputMismatchException("Position i was " + code[0]);
            }
            System.out.println(Arrays.toString(opcode));
            i += increase;
        }

        return outputs.toString();
    }

    public static int[] getCode(int num) {
        if (num % 100 == 99) {
            return new int[]{99};
        } else if (num % 100 == 3) {
            return new int[]{3, 1};
        } else if (num % 100 == 4) {
            return new int[]{4, 0};
        } else if (num % 100 == 5 || num % 100 == 6) {
            return new int[]{num % 100, num / 100 % 10, num / 1000 % 10};
        }
        int[] code = new int[4];

        code[0] = num % 100;
        num /= 100;
        code[1] = num % 10;
        num /= 10;
        code[2] = num % 10;
        code[3] = 1;
//        System.out.println(index + " " + Arrays.toString(code));
        return code;
    }

    private static void getValues(int[] code, int[] opcode, int index) {
        for (int i = 1; i < code.length; i++) {
            if (code[i] == 1) {
                // Immediate mode: actual value
                code[i] = opcode[index + i];

            } else if (code[i] == 0) {
                // Position mode: value in the parameter
                code[i] = opcode[opcode[index + i]];
            }
        }
        System.out.println(index + " " + Arrays.toString(code));
    }
}