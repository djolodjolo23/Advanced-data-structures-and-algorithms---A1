package helpers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Helper {

  public static <T> List<T> getAListOfAlgorithms(Supplier<T> supplier, int base, int power) {
    List<T> resultList = new ArrayList<>();

    for (int i = 1; i <= power; i++) {
      T instance = supplier.get();
      // You can also pass 'base' or any other parameters required by the constructor here.
      resultList.add(instance);
    }

    return resultList;
  }



}
