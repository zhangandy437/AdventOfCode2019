package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class OrbitIn {

    public static String[] getOrbitIn(String filePath){
        try {
            return Files.readAllLines(Paths.get(filePath)).toArray(String[]::new);
        } catch (IOException e) {
            System.out.println("File doesn't exist");
            System.exit(0);
        }
        return null;
    }
}
