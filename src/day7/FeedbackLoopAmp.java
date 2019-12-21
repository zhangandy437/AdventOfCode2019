package day7;

import day2.OpCodeInput;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class FeedbackLoopAmp {

    public static void main(String[] args) {
        List<Integer> outputs = new ArrayList<>();
        int current = 0;
        for (List<Integer> perm : Permutations.generatePermutations59()) {
            try {
                Amplifier[] amps = new Amplifier[5];

                int cur = 0;
                for (int i = 0; i < 5; i++) {
                    amps[i] = new Amplifier("./src/day7/in.txt");
                    cur = amps[i].getNextOutput(perm.get(i), cur);
                }
                int i = 0;
                while (true) {
                    cur = amps[i % 5].getNextOutput(cur);
                    if (i % 5 == 4) {
                        current = cur;
                    }
                    i++;
                }
            } catch (InputMismatchException e){
                outputs.add(current);
            }
        }
        System.out.println(outputs.stream().max(Integer::compareTo));
    }
}