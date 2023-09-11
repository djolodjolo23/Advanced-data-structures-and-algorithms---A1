package problem4;

import helpers.RandomNumbersGenerator;
import java.util.Arrays;
import problem1.UnionFind;
import problem2.WQUnionFind;
import problem3.Timer;

public class Main {

  public static void main(String[] args) {

    var uf = new UnionFind(1000000);

    var wqUf = new WQUnionFind(1000000);


    var timer = new Timer();

    var randGenerator = new RandomNumbersGenerator();


    String time = timer.timeItString(() -> uf.makeUnion(1, 2));

    String time2 = timer.timeItString(() -> wqUf.makeUnion(1, 2));
    String time3 = timer.timeItString(() -> wqUf.makeUnion(3, 4));

    wqUf.setArray(randGenerator.getRandomNumbers(10, 10000));

    System.out.println(Arrays.toString(wqUf.getParent()));




  }


}
