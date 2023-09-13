package problem2;

import helpers.AlgorithmInit;
import java.util.Random;

public class PCUnionFind implements AlgorithmInit {
  private int[] parent;
  private int[] size;



  public PCUnionFind() {

  }

  public void initializeArray(int num) {
    this.parent = new int[num];
    this.size = new int [num];
    for (int i = 0; i < num; i++) {
      size[i] = 1;
      parent[i] = i;
    }
  }

  public void setArray(int[] array) {
    this.parent = new int[array.length];
    this.size = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      parent[i] = array[i];
      size[i] = 1;
    }
  }


  public int[] getParent() {
    return parent;
  }

  public int[] getSize() {
    return size;
  }

  public boolean connected(int[] list, int a, int b) {
    return list[a] == list[b];
  }

  public int findRoot (int element) {
    while (element != parent[element]) {
      parent[element] = parent[parent[element]];
      element = parent[element];
    }
    return element;
  }

  public void makeUnion(int element_a, int element_b) {
    int root_a = findRoot(element_a);
    int root_b = findRoot(element_b);

    if (size[root_a] < size[root_b]) {
      parent[root_a] = root_b;
      size[root_b] += size[root_a];
    } else {
      parent[root_b] = root_a;
      size[root_a] += size[root_b];
    }
  }


  @Override
  public void init(int num) {
    this.parent = new int[num];
    this.size = new int[parent.length];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }
}
