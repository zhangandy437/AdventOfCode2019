package day3;

import java.util.Objects;

public class Point {

    private int x;
    private int y;
    private int step;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStep(){
        return step;
    }

    public static int distance(Point p1, Point p2){
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    public void increment(Point p){
        this.x += p.getX();
        this.y += p.getY();
        step++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    public Point copy(){
        return new Point(this.x, this.y);
    }
}
