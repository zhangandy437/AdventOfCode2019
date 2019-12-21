package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class OpCodeParser {
    public static String parse(int[] opcode, int input) {
        int i = 0;
        List<Integer> outputs = new ArrayList<>();

        while (i < opcode.length) {
            int increase = 4;
            int[] code = getCode(opcode[i]);
            getValues(code, opcode, i);

            switch(code[0]){
                case 99 -> {
                    return outputs.toString();
                }
                case 1 -> opcode[code[3]] = code[1] + code[2];
                case 2 -> opcode[code[3]] = code[1] * code[2];
                case 3 -> {
                    increase = 2;
                    opcode[code[1]] = input;
                }
                case 4 ->{
                    increase = 2;
                    outputs.add(code[1]);
                }
                case 5 -> {
                    if(code[1] != 0){
                        increase = 0;
                        i = code[2];
                    } else {
                        increase = 3;
                    }
                }
                case 6 -> {
                    if(code[1] == 0){
                        increase = 0;
                        i = code[2];
                    } else {
                        increase = 3;
                    }
                }
                case 7 -> {
                    if(code[1] < code[2]){
                        opcode[code[3]] = 1;
                    } else {
                        opcode[code[3]] = 0;
                    }
                }
                case 8 -> {
                    if(code[1] == code[2]){
                        opcode[code[3]] = 1;
                    } else {
                        opcode[code[3]] = 0;
                    }
                }
                default -> throw new InputMismatchException("Position i was " + code[0]);
            }
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
    }
}