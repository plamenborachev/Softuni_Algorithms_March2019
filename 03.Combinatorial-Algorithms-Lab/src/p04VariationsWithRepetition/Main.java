package p04VariationsWithRepetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static char[] elements;
    private static char[] variation;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        elements = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            elements[i] = input[i].charAt(0);
        }

        int k = Integer.parseInt(reader.readLine());
        variation = new char[k];

        generateVariations(0);
    }

    private static void generateVariations(int index) {
        if (index >= variation.length) {
            for (char c : variation) {
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }
        Set<Character> swapped = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            variation[index] = elements[i];
            generateVariations(index + 1);
        }
    }
}
