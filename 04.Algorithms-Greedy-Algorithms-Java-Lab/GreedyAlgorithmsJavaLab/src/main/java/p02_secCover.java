import java.util.*;
import java.util.stream.Collectors;

public class p02_secCover {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(in.nextLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = in.nextLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }

        List<int[]> choosenSets = chooseSets(sets, universe);

        System.out.println(choosenSets);
    }

    static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> universeSet = new HashSet<>();
        for (int i : universe) {
            universeSet.add(i);
        }
        Set<int[]> setsSet = new HashSet<>(sets);
        while (universeSet.size() > 0){
            int[] currentSet = setsSet.stream()
                    .sorted((s1, s2) -> Integer.compare(s2.length, s1.length))
                    .collect(Collectors.toList()).get(0);

            result.add(currentSet);
            setsSet.remove(currentSet);

            for (int number : currentSet) {
                universeSet.remove(number);
            }
        }
        return result;
    }
}
