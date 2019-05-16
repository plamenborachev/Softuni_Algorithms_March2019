package p06SubsetSumNoRepeat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, Integer> calcSums(int[] numbers){

        Map<Integer, Integer> result = new HashMap<>();

        result.put(0, 0);

        for (int currentNumber : numbers) {

            Map<Integer, Integer> newSums = new HashMap<>();

            for (Integer sum : result.keySet()) {
                int newSum = sum + currentNumber;
                newSums.putIfAbsent(newSum, currentNumber);
            }

            for (Map.Entry<Integer, Integer> sum : newSums.entrySet()) {
                result.putIfAbsent(sum.getKey(), sum.getValue());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[] {3, 5, 1, 4, 2};

        Map<Integer, Integer> sums = calcSums(numbers);

        int targetSum = 14;

        if (sums.containsKey(targetSum)){

            while (targetSum != 0){
                int number = sums.get(targetSum);
                targetSum -= number;
                System.out.print(number);
            }

        }
    }
}
