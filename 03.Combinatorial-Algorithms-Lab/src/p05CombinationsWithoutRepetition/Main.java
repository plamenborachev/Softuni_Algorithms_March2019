package p05CombinationsWithoutRepetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static char[] elements;
    private static char[] combination;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        elements = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            elements[i] = input[i].charAt(0);
        }

        int k = Integer.parseInt(reader.readLine());
        combination = new char[k];

        generateCombinations(0, 0);
    }

    private static void generateCombinations(int index, int start) {
        if (index >= combination.length) {
            for (char c : combination) {
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < elements.length; i++) {
            combination[index] = elements[i];
            generateCombinations(index + 1, i + 1);
        }
    }
}
