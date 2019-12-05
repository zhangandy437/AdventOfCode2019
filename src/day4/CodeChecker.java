package day4;

public class CodeChecker {

    public static boolean withinConstraints(int val) {
        if (notWithinBounds(val)) {
            return false;
        }

        int x = 10;
        int before;

        boolean hasDouble = false;

        while (val > 0) {
            before = x;
            x = val % 10;
            val /= 10;
            if (x > before) {
                return false;
            } else if (x == before) {
                hasDouble = true;
            }
        }

        return hasDouble;
    }

    public static boolean notWithinBounds(int val){
        return val < SecureContainerMain.LOWER || val > SecureContainerMain.UPPER;
    }

    public static boolean withinPart2Constraints(int val) {
        if (notWithinBounds(val)) {
            return false;
        }
        int x = 10;
        int before;

        int consCount = 1;
        boolean hasDouble = false;

        while (val > 0) {
            before = x;
            x = val % 10;
            val /= 10;
            if (x > before) {
                return false;
            } else if (!hasDouble && x == before) {
                consCount++;
            } else {
                if(!hasDouble && consCount == 2){
                    hasDouble = true;
                } else {
                    consCount = 1;
                }
            }
        }

        return hasDouble || consCount == 2;
    }
}
