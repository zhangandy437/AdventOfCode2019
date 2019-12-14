package day2;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;

public class OpCodeParser {

    public static int parse(int[] opcode, int noun, int verb) {
        error1202(opcode, noun, verb);

        boolean hasEnded = false;
        int i = 0;

        while (i < opcode.length && !hasEnded) {
            if (opcode[i] == 99) {
                hasEnded = true;
            } else if (opcode[i] == 1) {
                opcode[opcode[i + 3]] = opcode[opcode[i + 1]] + opcode[opcode[i + 2]];
            } else if (opcode[i] == 2) {
                opcode[opcode[i + 3]] = opcode[opcode[i + 1]] * opcode[opcode[i + 2]];
            } else if (opcode[i] == 3) {

            } else if (opcode[i] == 4) {

            } else {
                throw new InputMismatchException("Position i was " + opcode[i]);
            }
            i += 4;
        }
        return opcode[0];
    }

    private static void error1202(int[] opcode, int noun, int verb) {
        opcode[1] = noun;
        opcode[2] = verb;
    }

}
