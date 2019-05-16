package p07LongestCommonSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first = reader.readLine();
        String second = reader.readLine();

        int[][] lcs = new int[first.length() + 1][second.length() + 1];

        for (int row = 1; row <= first.length(); row++) {
            for (int col = 1; col <= second.length(); col++) {
                int up = lcs[row - 1][col];
                int left = lcs[row][col - 1];

                int result = Math.max(up, left);

                if (first.charAt(row - 1) == second.charAt(col - 1)){
                    result = Math.max(lcs[row - 1][col - 1] + 1, result);
                }

                lcs[row][col] = result;
            }
        }

        System.out.println(lcs[first.length()][second.length()]);

        var currentRow = first.length();
        var currentCol = second.length();

        List<Character> result = new ArrayList<Character>();

        while (currentRow > 0 && currentCol > 0){
            if (first.charAt(currentRow - 1) == second.charAt(currentCol - 1)
                && lcs[currentRow][currentCol] - 1 == lcs[currentRow - 1][currentCol - 1]){
                result.add(first.charAt(currentRow - 1));
                currentCol--;
                currentRow--;
            } else if (lcs[currentRow - 1][currentCol] == lcs[currentRow][currentCol]){
                currentRow--;
            } else {
                currentCol--;
            }
        }

        result.forEach(System.out::println);


    }
}
