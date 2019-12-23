package day8;

public class Pixel {
    public Pixel(int val) {
        this.val = val;
        amount = 1;
    }

    private int val;
    private int amount;

    public void increment(){
        amount++;
    }

    public int getVal() {
        return val;
    }

    public int getAmount() {
        return amount;
    }
}
