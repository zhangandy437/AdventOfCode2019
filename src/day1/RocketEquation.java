package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RocketEquation {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("./src/day1/input.txt"));

        int sum = 0;
        while(scan.hasNextInt()){
            sum += rocketBoi(scan.nextInt());
        }

        System.out.println(sum);
    }

    private static int rocketBoi(int i){
        i = i / 3 - 2;
        if(i <= 0){
            return 0;
        }
        return i + rocketBoi(i);
    }
}
