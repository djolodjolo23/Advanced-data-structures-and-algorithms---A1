package problem4;

import problem1.UnionFind;
import problem2.WQUnionFind;
import problem3.Timer;

public class Main {

  public static void main(String[] args) {

    var uf = new UnionFind(1000000);

    var wqUf = new WQUnionFind(1000000);


    var timer = new Timer();



    String time = timer.timeIt(() -> uf.makeUnion(1, 2));

    String time2 = timer.timeIt(() -> wqUf.makeUnion(1, 2));



    System.out.println(time);
    System.out.println(time2);
  }


}
