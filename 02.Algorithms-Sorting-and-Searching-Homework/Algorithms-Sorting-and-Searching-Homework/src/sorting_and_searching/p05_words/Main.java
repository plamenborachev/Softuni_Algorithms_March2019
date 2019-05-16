package sorting_and_searching.p05_words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static char[] elements;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        elements = input.toCharArray();
        gen(0);
        System.out.println(count);
    }

    private static void gen(int index) {
        if (index >= elements.length){
            for (int i = 1; i < elements.length; i++) {
                if (elements[i] == elements[i - 1]){
                    return;
                }
            }
            count++;
        } else {
            Set<Character> swapped = new HashSet<>();
            for (int i = index; i < elements.length; i++) {
                if (!swapped.contains(elements[i])){
                    swap(index, i);
                    gen(index + 1);
                    swap(index, i);
                    swapped.add(elements[i]);
                }
            }
        }
    }

    private static void swap(int first, int second) {
        char temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}
