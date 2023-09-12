package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Helper {

  public static <T extends AlgorithmInit> List<T> getAListOfAlgorithms(Supplier<T> supplier, int base, int upToExponent) {
    List<T> resultList = new ArrayList<>();

    for (int i = 1; i <= upToExponent; i++) {
      T instance = supplier.get();
      instance.init(base, i);
      resultList.add(instance);
    }
    return resultList;
  }



}
