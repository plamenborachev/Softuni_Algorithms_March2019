package p02LongestZigZagSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[numbers.length][2];
        int[][] prev = new int[numbers.length][2];

        dp[0][0] = dp[0][1] = 1;
        prev[0][0] = prev[0][1] = -1;

        int maxResult = 0;
        int maxIndexRow = 0;
        int maxIndexCol = 0;

        for (int currentIndex = 1; currentIndex < numbers.length; currentIndex++) {
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {
                int currentNumber = numbers[currentIndex];
                int prevNumber = numbers[prevIndex];

                if (currentNumber > prevNumber && dp[currentIndex][0] < dp[prevIndex][1] + 1){
                    dp[currentIndex][0] = dp[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;
                } else if (currentNumber < prevNumber && dp[currentIndex][1] < dp[prevIndex][0] + 1){
                    dp[currentIndex][1] = dp[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }

            if (dp[currentIndex][0] > maxResult){
                maxResult = dp[currentIndex][0];
                maxIndexRow = currentIndex;
                maxIndexCol = 0;
            }
            if (dp[currentIndex][1] > maxResult){
                maxResult = dp[currentIndex][1];
                maxIndexRow = currentIndex;
                maxIndexCol = 1;
            }
        }

        List<Integer> result = new ArrayList<>();

        while (maxIndexRow >= 0){
            result.add(numbers[maxIndexRow]);
            maxIndexRow = prev[maxIndexRow][maxIndexCol];
            if (maxIndexCol == 1){
                maxIndexCol = 0;
            } else {
                maxIndexCol = 1;
            }

        }

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}
