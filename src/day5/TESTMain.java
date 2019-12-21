package day5;

import day2.OpCodeInput;

import java.io.File;
import java.util.Arrays;

public class TESTMain {

    public static void main(String[] args){
        System.out.println(OpCodeParser.parse(OpCodeInput.getFromFile(new File("./src/day5/in.txt")),5));
    }
}
