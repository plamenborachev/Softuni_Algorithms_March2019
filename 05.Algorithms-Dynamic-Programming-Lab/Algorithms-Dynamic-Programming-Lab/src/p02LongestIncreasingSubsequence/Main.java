package p02LongestIncreasingSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int[] numbers = {3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1};
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] solutions = new int[numbers.length];
        int maxSolution = 0;

        int[] prev = new int[numbers.length];
        int maxSolutionIndex = 0;

        for (int current = 0; current < numbers.length; current++) {
            int solution = 1;
            int prevIndex = -1;
            int currentNumber = numbers[current];

            for (int solIndex = 0; solIndex < current; solIndex++) {
                int prevNumber = numbers[solIndex];
                int prevSolution = solutions[solIndex];

                if(currentNumber > prevNumber && solution <= prevSolution){
                    solution = prevSolution + 1;
                    prevIndex = solIndex;
                }
            }

            solutions[current] = solution;
            prev[current] = prevIndex;

            if (solution > maxSolution){
                maxSolution = solution;
                maxSolutionIndex = current;
            }
        }

        int index = maxSolutionIndex;

        List<Integer> result = new ArrayList<>();

        while (index != -1){
             int currentNumber = numbers[index];
             result.add(currentNumber);
            index = prev[index];
        }

        for (int i = result.size() - 1; i >= 0 ; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}
