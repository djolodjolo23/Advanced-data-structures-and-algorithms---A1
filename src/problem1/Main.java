package problem1;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    var uf = new UnionFind();

    int[] list = uf.initializeArray(10);

    System.out.println(Arrays.toString(list));

    uf.makeUnion(list, 0, 1);
    uf.makeUnion(list, 6, 7);

    System.out.println(Arrays.toString(list));

    uf.makeUnion(list, 1, 2);

    System.out.println(Arrays.toString(list));

    System.out.println(uf.connected(list, 0, 2));
    System.out.println(uf.connected(list, 0, 3));

  }

}
