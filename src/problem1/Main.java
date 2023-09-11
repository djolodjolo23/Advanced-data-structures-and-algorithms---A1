package problem1;

import helpers.Helper;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    var uf = new UnionFind(10);

    List<UnionFind> ufs = Helper.getAListOfAlgorithms(() -> new UnionFind(10), 10, 2);
    System.out.println(Arrays.toString(uf.getArray()));

    uf.makeUnion(0, 1);
    System.out.println(Arrays.toString(uf.getArray()));

    uf.makeUnion(6, 7);

    System.out.println(Arrays.toString(uf.getArray()));

    uf.makeUnion(1, 2);

    System.out.println(Arrays.toString(uf.getArray()));

    System.out.println(uf.connected(uf.getArray(), 0, 2));
    System.out.println(uf.connected(uf.getArray(), 0, 3));

  }

}
