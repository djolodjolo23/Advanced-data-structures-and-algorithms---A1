package helpers;

import java.util.Random;

public class RandomNumbersGenerator {

    Random random;

    public RandomNumbersGenerator() {
        random = new Random();
    }

    public int[] getRandomNumbers (int arraySize, int maxNum) {
        int[] randomArray = new int[arraySize];
        for (int i=0; i < arraySize; i++) {
            randomArray[i] = random.nextInt(maxNum + 1);
        }
        return randomArray;
    }





}
