package day4;

public class SecureContainerMain {

    final static int LOWER = 273025;
    final static int UPPER = 767253;

    public static void main(String[] args){

        // Part 1
        System.out.println(CodeFinder.backtrack(CodeFinder.getRealLower(LOWER)));

        // Part 2
        // Couldn't think of a way to backtrack this one so I had to brute force it
        int total = 0;
        for(int i = LOWER; i <= UPPER; i++){
            if(CodeChecker.withinPart2Constraints(i))
                total++;
        }
        System.out.println(total);
    }
}
