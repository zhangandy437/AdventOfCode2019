package day3;

import java.util.*;

public class Intersection {

    public static List<Point> findIntersections(List<Wire> wire, HashSet<Point> points){

        List<Point> intersections = new ArrayList<Point>();
        Point current = new Point(0, 0);
        for (Wire w : wire) {
            for (int i = 0; i < w.getLength(); i++) {
                current.increment(w.getDirection().getPoint());
                if (i != 0 && points.contains(current)){
                    intersections.add(current.copy());
                }
            }
        }
        return intersections;
    }

    public static HashSet<Point> hashSetWire(List<Wire> wire){
        HashSet<Point> points = new HashSet<Point>();

        Point current = new Point(0, 0);

        for (Wire w : wire) {
            for (int i = 0; i < w.getLength(); i++) {
                current.increment(w.getDirection().getPoint());
                points.add(current.copy());
            }
        }
        return points;
    }

    public static HashMap<Point, Integer> hashMapWire(List<Wire> wire){
        HashMap<Point, Integer> points = new HashMap<Point, Integer>();
        Point current = new Point(0, 0);

        for (Wire w : wire) {
            for (int i = 0; i < w.getLength(); i++) {
                current.increment(w.getDirection().getPoint());
                if(!points.containsKey(current)){
                    points.put(current.copy(), current.getStep());
                }
            }
        }
        return points;
    }

    public static int lowestStepIntersection(List<Wire> wire, HashMap<Point, Integer> points){
        List<Integer> intersections = new ArrayList<Integer>();
        Point current = new Point(0, 0);
        for (Wire w : wire) {
            for (int i = 0; i < w.getLength(); i++) {
                current.increment(w.getDirection().getPoint());
                if (i != 0 && points.containsKey(current)){
                    intersections.add(current.getStep() + points.get(current));
                }
            }
        }
        return intersections.stream().min((a,b) -> a - b).get();
    }
}
