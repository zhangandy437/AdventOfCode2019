package day3;

public class Wire {

    private Direction direction;
    private int length;

    public Wire(Direction direction, int length) {
        this.direction = direction;
        this.length = length;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }
}
