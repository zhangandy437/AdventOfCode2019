package day7;

import day2.OpCodeInput;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmplifierMain {

    private final static int FIRST_AMP_INPUT = 0;

    public static void main(String[] args){
        int[] opcode = OpCodeInput.getFromFile(new File("./src/day7/in.txt"));

        List<Integer> outputs = new ArrayList<>();

        List<List<Integer>> perm = Permutations.generatePermutations04();
        for(List<Integer> cur : perm){

            int in = FIRST_AMP_INPUT;
            for(int i : cur){
                in = OpCodeParser.parse(Arrays.copyOf(opcode, opcode.length), i, in);
            }
            outputs.add(in);
        }

        System.out.println(outputs.stream().max(Integer::compareTo));


    }
}
