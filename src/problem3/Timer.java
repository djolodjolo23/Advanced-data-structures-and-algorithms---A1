package problem3;


import java.util.ArrayList;
import java.util.List;

public class Timer{
  private long startTime;
  private long endTime;

  private long elapsedTime;


  public String timeItString(MyMethod method) {
    start();
    method.execute();
    stop();
    elapsedTime = getElapsedTime();
    return toString();
  }

  public long timeItNanoTime(MyMethod method) {
    start();
    method.execute();
    stop();
    return getElapsedTime();
  }



  private void start() {
    startTime = System.nanoTime();
  }

  private void stop() {
    endTime = System.nanoTime();
  }

  private long getElapsedTime() {
    if (startTime != 0 && endTime != 0) {
      return endTime - startTime;
    } else {
      throw new IllegalStateException("Timer not started or stopped correctly.");
    }
  }

  public long[] findAverageRunningTime(List<List<Long>> listOfValues) {
    int totalLists = listOfValues.size();
    int totalEntries = listOfValues.get(0).size();

    long[] averages = new long[totalEntries];

    for (int i = 0; i < totalEntries; i++) {
      long sum = 0;
      for (List<Long> list : listOfValues) {
        sum += list.get(i);
      }
      averages[i] = sum / totalLists;
    }
    return averages;
  }


  public long findWorstRunningTime(long[] times) {
    long worstTime = times[0];
    for (long time: times) {
      if (time < worstTime) {
        worstTime = time;
      }
    }
    return worstTime;
  }

  public long findBestRunningTime(long[] times) {
    long bestTime = times[0];
    for (long time: times) {
      if (time > bestTime) {
        bestTime = time;
      }
    }
    return bestTime;
  }


  @Override
  public String toString() {
    long milliseconds = elapsedTime / 1_000_000;
    long microseconds = (elapsedTime % 1_000_000) / 1_000;
    long nanoseconds = elapsedTime % 1_000;
    return
        "Elapsed time = " + milliseconds + "ms, " +
        microseconds + " µs, " +
        nanoseconds + " ns.";
  }


}
