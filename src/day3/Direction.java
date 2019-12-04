package day3;

public enum Direction {
    UP, DOWN, RIGHT, LEFT;

    private Point direction;
    private char string;

    static{
        UP.direction = new Point(0, -1);
        DOWN.direction = new Point(0, 1);
        RIGHT.direction = new Point(1, 0);
        LEFT.direction = new Point(-1, 0);

        UP.string = 'U';
        DOWN.string = 'D';
        RIGHT.string = 'R';
        LEFT.string = 'L';
    }

    public static Direction get(char s){
        if(s == UP.string){
            return Direction.UP;
        } else if(s == DOWN.string){
            return Direction.DOWN;
        } else if(s == LEFT.string){
            return Direction.LEFT;
        }
        return Direction.RIGHT;
    }

    public Point getPoint(){
        return this.direction;
    }
}
