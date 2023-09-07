package problem1;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    var uf = new UnionFind(10);


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
