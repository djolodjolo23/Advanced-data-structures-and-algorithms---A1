package problem7;

import problem3.Timer;
import problem5.BruteForce3Sum;
import problem6.Smart3Sum;

import java.sql.Time;

public class Main {

    public static void main(String[] args) {

        var bf3s = new BruteForce3Sum(1000);

        var sm3s = new Smart3Sum(1000);

        var timer = new Timer();

        String time1 = timer.timeIt (() -> bf3s.findCombinations(180));
        String time2 = timer.timeIt(() -> sm3s.findCombinations(180));

        System.out.println(time1);
        System.out.println(time2);


    }
}
