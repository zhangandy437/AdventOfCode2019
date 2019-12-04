package day3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CrossedWiresMain {
    public static void main(String[] args) {
        List<List<Wire>> wires = DirectionReader.parseFile("./src/day3/input.txt");

        // Part 1
        HashSet<Point> points = Intersection.hashSetWire(wires.get(0));
        List<Point> intersections = Intersection.findIntersections(wires.get(1), points);
        Point origin = new Point(0, 0);
        Point min = intersections.stream().min(Comparator.comparingInt(a -> Point.distance(origin, a))).get();

        System.out.println(min);
        System.out.println(Point.distance(origin, min));

        // Part 2
        HashMap<Point, Integer> pointsStep = Intersection.hashMapWire(wires.get(0));
        System.out.println(Intersection.lowestStepIntersection(wires.get(1), pointsStep));


    }
}
