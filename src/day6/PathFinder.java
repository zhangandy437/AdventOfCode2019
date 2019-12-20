package day6;

import java.util.HashMap;

public class PathFinder {
    public static int getAmountOfJumps(String[] orbits, String start, String end) {
        HashMap<String, Planet> children = hashDoubleEndedOrbits(orbits);

        HashMap<String, Integer> youPath = hashFromYou(children, start);

        String cur = end;
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

    private static HashMap<String, Integer> hashFromYou(HashMap<String,Planet> children, String start){
        HashMap<String, Integer> youPath = new HashMap<>();

        String cur = start;
        int i = -1;
        while(!cur.equals("COM")){
            youPath.put(cur, i++);
            cur = children.get(cur).getHead();
        }

        return youPath;
    }
}
