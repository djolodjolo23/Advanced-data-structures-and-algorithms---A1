package problem2;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    var uf = new WQUnionFind(7);

    uf.makeUnion(1, 2);

    System.out.println(Arrays.toString(uf.getSize()) + Arrays.toString(uf.getParent()));

    uf.makeUnion(3, 4);

    System.out.println(Arrays.toString(uf.getSize()) + Arrays.toString(uf.getParent()));

    uf.makeUnion(1, 2);

    System.out.println(Arrays.toString(uf.getSize()) + Arrays.toString(uf.getParent()));

    uf.makeUnion(6, 3);

    System.out.println(Arrays.toString(uf.getSize()) + Arrays.toString(uf.getParent()));

  }

}
