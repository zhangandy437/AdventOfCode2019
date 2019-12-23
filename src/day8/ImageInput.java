package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ImageInput {
    public static int[] input(String filePath) {
        try {
            List<String> boi = Files.readAllLines(Path.of(filePath));
            System.out.println(boi.get(0).length());
            return Arrays.stream(Files.readAllLines(Path.of(filePath)).get(0).split("")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            return null;
        }
    }
}
