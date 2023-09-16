package problem1;

import helpers.AlgorithmInit;

public class UnionFind implements AlgorithmInit {

  private int[] array;



  public UnionFind() {

  }


  public boolean connected(int a, int b) {
    return array[a] == array[b];
  }

  public int[] getArray() {
    return array;
  }

  public void makeUnion(int element_a, int element_b) {
    int a_id = array[element_a];
    int b_id = array[element_b];

    for (int ix = 0; ix < array.length; ix++) {
      int value = array[ix];
      if (value == a_id) {
        array[ix] = b_id;
      }
    }
  }

  @Override
  public void init(int num) {
    int[] nums = new int[num];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }
    this.array = nums;
  }
}
