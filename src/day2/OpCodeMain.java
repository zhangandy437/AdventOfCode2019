package day2;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;

public class OpCodeMain {
    public static void main(String[] args) {
        int[] original = OpCodeInput.getFromFile(new File("./src/day2/input.txt"));

        // Part 1
        int[] hold = Arrays.copyOf(original, original.length);
        OpCodeParser.parse(hold, 12, 2);

        System.out.println(hold[0]);

        // Part 2
        int target = 19690720;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] opcode = new int[original.length];
                System.arraycopy(original, 0, opcode, 0, original.length);
                try {
                    int test = OpCodeParser.parse(opcode, i, j);
                    System.out.println(String.format("Target = %d | Test = %d | noun = %d | verb = %d", target, test, i, j));
                } catch (InputMismatchException e){
                    System.out.println("Noun " + i + " and verb " + j + " failed.");
                }
            }
        }

    }
}
