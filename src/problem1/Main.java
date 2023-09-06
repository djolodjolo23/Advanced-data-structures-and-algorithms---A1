package problem1;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    var uf = new UnionFind();

    int[] arr = uf.initializeArray(10);

    System.out.println(Arrays.toString(arr));

    uf.makeUnion(arr, 0, 1);
    uf.makeUnion(arr, 6, 7);

    System.out.println(Arrays.toString(arr));

    uf.makeUnion(arr, 1, 2);

    System.out.println(Arrays.toString(arr));

    System.out.println(uf.connected(arr, 0, 2));
    System.out.println(uf.connected(arr, 0, 3));

  }

}
