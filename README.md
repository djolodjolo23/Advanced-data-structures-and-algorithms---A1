- The src package contains sub-packages for each problem. In each sub-package there is a main class with a main method inside where 
the code can be compiled and executed.
- Helper and Timer classes are responsible for calculations and time measurements. 
- AlgorithmInit is an interface implemented by all the algorithms with init() method, to be able to use it when working with generic method for creating a list of algorithms with different array sizes.
- CSVExporter is a class I used for exporting the data to csv file and using it for graphs and report.
- Testing classes can be ignored, I used these to perform tests on different array sizes.


- Problem 1:
  - Union find object is created and the array is initiated with the init() method. The method makeUnion() or connected() 
  can be called for any two elements in the array.
- Problem 2:
  - Path compression union find object is created and the array is initiated with the init() method. The method makeUnion() or connected()
    can be called for any two elements in the array.
- Problem 3:
  - Timer class is implemented with Functional interface to be able to measure the running time for any method passed as a parameter. 
  Timer class also contains several methods for calculation, nano time returns, strings and more.
- Problem 4:
    - Most of the calculations are presented in the report. However, a main class contains objects where each method from these objects can be tested. Time is measured through lambda expression in timeIt() method, where the method returns either time in nano time or time converted to string and printed out nicely.
- Problem 5:
  - Brute force 3 sum object is created and the array is initiated through the init() method. The findCombinations() method can be called from the object with target value as a parameter.
- Problem 6:
  -  Smart 3 sum object is created and the array is initiated through the init() method. The findCombinations() method can be called from the object with target value as a parameter.

- Problem 7:
  - Most of the calculations are presented in the report. However, a main class contains objects where each method from these objects can be tested.Time is measured through lambda expression in timeIt() method, where the method returns either time in nano time or time converted to string and printed out nicely.