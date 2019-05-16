package greedy_algorithms.p05_egyptianFractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numberTokens = reader.readLine().split("/");
        long numerator = Long.parseLong(numberTokens[0]);
        long denominator = Long.parseLong(numberTokens[1]);

        if (numerator >= denominator){
            System.out.println("Error (fraction is equal to or greater than 1)");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d/%d = ", numerator, denominator));

        long newDenominator = 2;

        while (numerator != 0) {
            long currentNumerator = numerator * newDenominator - denominator;
            long currentDenominator = denominator * newDenominator;
            if (currentNumerator < 0) {
                newDenominator++;
                continue;
            }
            if (currentNumerator != 0){
                sb.append(String.format("1/%d + ", newDenominator));
            } else {
                sb.append(String.format("1/%d", newDenominator));
            }
            numerator = currentNumerator;
            denominator = currentDenominator;
            newDenominator++;
        }

        System.out.println(sb.toString());
    }
}
