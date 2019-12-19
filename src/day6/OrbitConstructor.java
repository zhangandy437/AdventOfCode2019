package day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OrbitConstructor {

    private final static String HEAD = "COM";
    private final static String YOU = "YOU";
    private final static String SAN = "SAN";

    public static int getAmountOfOrbits(String[] orbits) {
        return depthFirstSearch(hashOrbits(orbits), HEAD, 0);
    }

    private static HashMap<String, List<String>> hashOrbits(String[] orbits) {
        HashMap<String, List<String>> parents = new HashMap<>();

        for (String s : orbits) {
            String parent = s.substring(0, 3);
            String child = s.substring(4);

            if (parents.containsKey(parent)) {
                parents.get(parent).add(child);
            } else {
                List<String> cur = new ArrayList<>();
                cur.add(child);
                parents.put(parent, cur);
            }
        }

        return parents;
    }

    private static int depthFirstSearch(HashMap<String, List<String>> parents, String cur, int length) {
        if (!parents.containsKey(cur)) {
            return length;
        }
        int orbits = 0;

        for (String s : parents.get(cur)) {
            orbits += depthFirstSearch(parents, s, length + 1);
        }

        return orbits + length;
    }

    public static int getAmountOfJumps(String[] orbits) {
        HashMap<String, Planet> children = hashDoubleEndedOrbits(orbits);

        HashMap<String, Integer> youPath = hashFromYou(children);

        String cur = SAN;
        int len = -1;
        while(true){
            if(youPath.containsKey(cur)){
                return len + youPath.get(cur);
            } else {
                cur = children.get(cur).getHead();
            }
            len++;
        }

    }

    private static HashMap<String, Planet> hashDoubleEndedOrbits(String[] orbits) {
        HashMap<String, Planet> children = new HashMap<>();

        for (String s : orbits) {
            String parent = s.substring(0, 3);
            String child = s.substring(4);

            Planet cur = new Planet(child, parent);
            children.put(child, cur);
        }

        return children;
    }

    private static HashMap<String, Integer> hashFromYou(HashMap<String,Planet> children){
        HashMap<String, Integer> youPath = new HashMap<>();

        String cur = YOU;
        int i = -1;
        while(!cur.equals("COM")){
            youPath.put(cur, i++);
            cur = children.get(cur).getHead();
        }

        return youPath;
    }
}
