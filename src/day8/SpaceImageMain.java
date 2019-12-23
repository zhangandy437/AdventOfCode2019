package day8;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SpaceImageMain {

    private final static int LENGTH = 25;
    private final static int WIDTH = 6;
    private final static int AREA = LENGTH * WIDTH;

    public static void main(String[] args){
        int[] pixels = ImageInput.input("./src/day8/in.txt");

        int[][] layers = LayerGen.genCumulativeLayers(pixels, AREA);

        Arrays.stream(layers).mapToInt(i -> i[0]).forEach(System.out::println);
        System.out.println(layers[5][1] * layers[5][2]);

        JFrame frame = LayerGen.genImage(pixels, AREA);
        frame.setVisible(true);

    }


}
