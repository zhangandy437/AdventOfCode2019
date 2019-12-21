package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> generatePermutations04() {
        List<Integer> original = Arrays.asList(0, 1, 2, 3, 4);
        List<List<Integer>> permutations = new ArrayList<>();
        permute(original, 0, permutations);
        return permutations;
    }

    public static List<List<Integer>> generatePermutations59() {
        List<Integer> original = Arrays.asList(5, 6, 7, 8, 9);
        List<List<Integer>> permutations = new ArrayList<>();
        permute(original, 0, permutations);
        return permutations;
    }

    private static void permute(List<Integer> arr, int k, List<List<Integer>> perms) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1, perms);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            perms.add(Arrays.asList(arr.toArray(Integer[]::new)));
        }
    }

}
