package day4;

public class CodeFinder {

    private final static int[] ADD = new int[] {11111, 1111, 111, 11, 1};

    private final static int[] LOWERS = new int[] {111111, 222222, 333333, 444444, 555555, 666666, 777777, 888888, 999999};

    public static int backtrack(int num){
        if(num == LOWERS[LOWERS.length - 1]){
            return 1;
        }
        int total = 0;
        int begin = -1;
        for(int i = 0; i < LOWERS.length - 1 && begin < 0; i++){
            if(num == LOWERS[i]){
                return backtrack(LOWERS[i], 0);
            } else if (num > LOWERS[i] && num < LOWERS[i + 1]) {
                begin = i;
            }
        }

        for(int i = begin; i < LOWERS.length; i++){
            if(LOWERS[i] <= SecureContainerMain.UPPER) {
                total += backtrack(LOWERS[i], 0);
            }
        }
        return backtrack(num, 0) + total;
    }

    private static int backtrack(int num, int index){
        if(!CodeChecker.withinConstraints(num)){
            return 0;
        }
        int amount = 1;
        for(int i = index; i < ADD.length; i++){
            amount += backtrack(num + ADD[i], i);
        }
        return amount;
    }

    public static int getRealLower(int lower){
        int numDig = (int) Math.log10(lower);

        int firstDigit = lower / (int) Math.pow(10, numDig);

        int lowest = repeatDigits(firstDigit, numDig);

        if(lowest < lower){
            return firstDigit * (int) Math.pow(10, numDig) + getRealLower(lower - firstDigit * (int) Math.pow(10, numDig));
        }
        return lowest;
    }

    private static int repeatDigits(int firstDigit, int numDig){
        int lowest = firstDigit;
        for(int i = 0; i < numDig; i++){
            lowest *= 10;
            lowest += firstDigit;
        }
        return lowest;
    }

    public static int getRealUpper(int upper){
        int numDig = (int) Math.log10(upper);

        int firstDigit = upper / (int) Math.pow(10, numDig);

        int lowest = repeatDigits(firstDigit, numDig);

        if(lowest > upper){
            return (firstDigit - 1) * (int) Math.pow(10, numDig) + repeatDigits(9, numDig - 1);
        }
        return lowest;
    }
}
