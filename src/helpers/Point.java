package helpers;

public class Point {
  private long y;
  private int x;

  public Point(int x, long y) {
    this.x = x;
    this.y = y;
  }

  public int getFirst() {
    return x;
  }

  public long getSecond() {
    return y;
  }
}
