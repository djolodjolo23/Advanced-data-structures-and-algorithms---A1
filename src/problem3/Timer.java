package problem3;

public class Timer{
  private long startTime;
  private long endTime;

  private long elapsedTime;


  public String timeIt(MyFunction function) { // I want to pass a void function as a parameter
    start();
    function.execute(); // function to be executed
    stop();
    elapsedTime = getElapsedTime();
    return toString();
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
