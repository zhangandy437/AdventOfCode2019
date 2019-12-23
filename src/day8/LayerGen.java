package day8;

import javax.swing.*;
import java.awt.*;

public class LayerGen {

    public static int[][] genCumulativeLayers(int[] pixels, int area){
        int[][] layers = new int[pixels.length / area][3];

        int cur = -1;
        for(int i = 0; i < pixels.length; i++){
            cur += i % area == 0 ? 1: 0;
            layers[cur][pixels[i]]++;
        }

        return layers;
    }

    public static JFrame genImage(int[] pixels, int area){
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(6, 25));
        frame.setSize(new Dimension(2500,600));

        for(JPanel p : initPanels(pixels, area)){
            frame.add(p);
        }
        return frame;
    }

    private static JPanel[] initPanels(int[] pixels, int area){
        JPanel[] panels = new JPanel[area];

        for(int i = 0 ; i < area; i++){
            panels[i] = new JPanel();
            panels[i].setPreferredSize(new Dimension(100, 100));
        }
        setColor(panels, pixels, area);

        return panels;
    }

    private static void setColor(JPanel[] panels, int[] pixels, int area){
        for(int i = pixels.length - 1; i > -1; i--){
            if(pixels[i] == 0){
                //black
                panels[i % area].setBackground(Color.BLACK);
            } else if(pixels[i] == 1){
                //white
                panels[i % area].setBackground(Color.WHITE);
            }
        }
    }
}
