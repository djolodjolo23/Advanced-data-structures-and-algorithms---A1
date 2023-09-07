package problem2;

public class WQUnionFind {
  private int[] parent;
  private int[] size;

  public WQUnionFind(int num) {
    initializeArray(num);
  }

  private void initializeArray(int num) {
    this.parent = new int[num];
    this.size = new int [num];
    for (int i = 0; i < num; i++) {
      size[i] = 1; // for tracking size
      parent[i] = i;
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


}
