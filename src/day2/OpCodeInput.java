package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class OpCodeInput {

    public static int[] getFromFile(File file){
        try{
            Scanner scan = new Scanner(file);
            String line = scan.nextLine();
            scan.close();
            return Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        } catch (FileNotFoundException e){
            System.out.println("Could not find file");
            System.exit(0);
        }
        return null;
    }
}
