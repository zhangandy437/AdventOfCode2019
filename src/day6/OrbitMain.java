package day6;

import java.util.Arrays;

public class OrbitMain {
    public static void main(String[] args){
        System.out.println(OrbitConstructor.getAmountOfOrbits(OrbitIn.getOrbitIn("./src/day6/in.txt")));

        System.out.println(PathFinder.getAmountOfJumps(OrbitIn.getOrbitIn("./src/day6/in.txt"), "YOU", "SAN"));
    }
}
