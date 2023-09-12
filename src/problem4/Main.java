package problem4;

import helpers.Helper;
import java.util.List;
import problem1.UnionFind;
import problem2.WQUnionFind;
import problem3.Timer;

public class Main {

  public static void main(String[] args) {



    List<UnionFind> unionFindList = Helper.getAListOfAlgorithms(UnionFind::new, 5, 7);
    List<WQUnionFind> wqUnionFindList = Helper.getAListOfAlgorithms(WQUnionFind::new, 5, 7);




    var timer = new Timer();


    for (UnionFind uf : unionFindList) {
      // skipping the first one bcs of JIT compilation warm up
      if (uf != unionFindList.get(0)) {
        System.out.println(timer.timeItNanoTime(() -> uf.makeUnion(3, 4)));
        System.out.println(timer.timeItNanoTime(() -> uf.connected(3, 4)));
      }
    }


    System.out.println();

    for (WQUnionFind wquf : wqUnionFindList) {
      // skipping the first one bcs of JIT compilation warm up
      long rt = timer.timeItNanoTime(() -> wquf.makeUnion(3, 4));
      if (wquf != wqUnionFindList.get(0)) {
        System.out.println(rt);
      }
    }






  }


}
