package p03VariationsWithoutRepetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static char[] elements;
    private static char[] vari;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        elements = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            elements[i] = input[i].charAt(0);
        }

        int k = Integer.parseInt(reader.readLine());
        vari = new char[k];

        used = new boolean[input.length];

        generateVariations(0);
    }

    private static void generateVariations(int index) {
        if (index >= vari.length){
            for (char c : vari) {
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }
        Set<Character> swapped = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]){
                used[i] = true;
                vari[index] = elements[i];
                generateVariations(index + 1);
                used[i] = false;
            }
        }
    }
}
