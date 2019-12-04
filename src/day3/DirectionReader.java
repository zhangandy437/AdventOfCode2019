package day3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DirectionReader {
    public static List<List<Wire>> parseFile(String filePath){
        try {
            return Files.readAllLines(Paths.get(filePath)).stream().map(s -> Arrays.stream(s.split(","))
                    .map(t -> new Wire(Direction.get(t.charAt(0)), Integer.parseInt(t.substring(1)))).collect(Collectors.toList()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
