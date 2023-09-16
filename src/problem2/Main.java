package problem2;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    var pcuf = new PCUnionFind();
    pcuf.init(7);

    pcuf.makeUnion(1, 2);

    System.out.println(Arrays.toString(pcuf.getSize()) + Arrays.toString(pcuf.getParent()));

    pcuf.makeUnion(3, 4);

    System.out.println(Arrays.toString(pcuf.getSize()) + Arrays.toString(pcuf.getParent()));

    pcuf.makeUnion(1, 2);

    System.out.println(Arrays.toString(pcuf.getSize()) + Arrays.toString(pcuf.getParent()));

    pcuf.makeUnion(6, 3);

    System.out.println(Arrays.toString(pcuf.getSize()) + Arrays.toString(pcuf.getParent()));

    System.out.println(pcuf.connected(6,3));

    System.out.println(pcuf.connected(6,4));



  }

}
