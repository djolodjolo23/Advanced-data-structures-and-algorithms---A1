package problem1;

import helpers.Helper;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

  public static void main(String[] args) {

    var uf = new UnionFind();

    Random random = new Random();
    uf.init(10000);

    random.nextInt(10, 2);


    System.out.println(Arrays.toString(uf.getArray()));

    uf.makeUnion(0, 1);
    System.out.println(Arrays.toString(uf.getArray()));

    uf.makeUnion(6, 7);

    System.out.println(Arrays.toString(uf.getArray()));

    uf.makeUnion(1, 2);

    System.out.println(Arrays.toString(uf.getArray()));

    System.out.println(uf.connected(0, 2));
    System.out.println(uf.connected(0, 3));

  }

}
