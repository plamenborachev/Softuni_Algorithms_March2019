package p03MoveDownRightSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        int[][] numbers = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] line = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < cols; j++) {
                numbers[i][j] = line[j];
            }
        }

        int[][] sums = new int[rows][cols];
        
        sums[0][0] = numbers[0][0];

        for (int row = 1; row < rows; row++) {
            sums[row][0] = sums[row - 1][0] + numbers[row][0];
        }

        for (int col = 1; col < cols; col++) {
            sums[0][col] = sums[0][col - 1] + numbers[0][col];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                int result = Math.max(sums[row - 1][col], sums[row][col - 1]) + numbers[row][col];

                sums[row][col] = result;
            }
        }

//        System.out.println(sums[rows - 1][cols - 1]);

        List<String> result = new ArrayList<>();

        result.add(String.format("[%d, %d]", (rows - 1), (cols - 1)));

        int currentRow = rows - 1;
        int currentCol = cols - 1;

        while (currentCol != 0 || currentRow != 0){
            int top = -1;
            if (currentRow - 1 >= 0){
                top = sums[currentRow - 1][currentCol];
            }

            int left = -1;
            if (currentCol - 1 >= 0){
                left = sums[currentRow][currentCol - 1];
            }

            if (top > left){
                result.add(String.format("[%d, %d]", currentRow - 1, currentCol));
                currentRow--;
            } else {
                result.add(String.format("[%d, %d]", currentRow, currentCol - 1));
                currentCol--;
            }
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}
