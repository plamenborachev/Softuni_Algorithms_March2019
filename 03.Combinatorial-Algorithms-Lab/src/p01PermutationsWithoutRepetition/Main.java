package p01PermutationsWithoutRepetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[] elements;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        elements = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            elements[i] = input[i].charAt(0);
        }
        generatePermutations(0);
    }

    private static void generatePermutations(int index) {
        if (index >= elements.length){
            for (char c : elements) {
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }
        generatePermutations(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(index, i);
            generatePermutations(index + 1);
            swap(index, i);
        }
    }

    private static void swap(int first, int second) {
        char temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}
