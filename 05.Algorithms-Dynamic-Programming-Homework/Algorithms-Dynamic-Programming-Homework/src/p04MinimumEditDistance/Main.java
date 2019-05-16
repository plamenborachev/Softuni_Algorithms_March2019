package p04MinimumEditDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int costReplace = Integer.parseInt(reader.readLine().split("\\s+")[2]);
        int costInsert = Integer.parseInt(reader.readLine().split("\\s+")[2]);
        int costDelete = Integer.parseInt(reader.readLine().split("\\s+")[2]);

        String first = reader.readLine().split("\\s+")[2];
        String second = reader.readLine().split("\\s+")[2];

        int[][] dp = new int[first.length() + 1][second.length() + 1];

        for (int i = 1; i <= second.length() ; i++) {
            dp[0][i] = dp[0][i - 1] + costInsert;
        }

        for (int i = 1; i <= first.length(); i++) {
            dp[i][0] = dp[i - 1][0] + costDelete;
        }

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.toCharArray()[i - 1] == second.toCharArray()[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete = dp[i - 1][j] + costDelete;
                    int insert = dp[i][j - 1] + costInsert;
                    int replace = dp[i - 1][j - 1] + costReplace;

                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }

        System.out.println(String.format("Minimum edit distance: %d", dp[first.length()][second.length()]));
    }
}
