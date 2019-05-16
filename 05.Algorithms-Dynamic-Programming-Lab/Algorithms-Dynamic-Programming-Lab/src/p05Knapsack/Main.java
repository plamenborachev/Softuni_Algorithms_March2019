package p05Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static class Item{
        private String name;
        private int weight;
        private int price;

        Item(String name, int weight, int price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        String getName() {
            return this.name;
        }

        int getWeight() {
            return this.weight;
        }

        int getPrice() {
            return this.price;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maxCapacity = Integer.parseInt(reader.readLine());

        String input = reader.readLine();

        List<Item> items = new ArrayList<>();

        while (!input.equals("end")){
            String[] itemTokens = input.split("\\s+");
            String itemName = itemTokens[0];
            int itemWeight = Integer.parseInt(itemTokens[1]);
            int itemPrice = Integer.parseInt(itemTokens[2]);

            Item item = new Item(itemName, itemWeight, itemPrice );
            items.add(item);

            input = reader.readLine();
        }

        int[][] prices = new int[items.size() + 1][maxCapacity + 1];
        boolean[][] itemsIncluded = new boolean[items.size() + 1][maxCapacity + 1];

        for (int itemIndex = 0; itemIndex < items.size(); itemIndex++) {
            Item item = items.get(itemIndex);
            int rowIndex = itemIndex + 1;

            for (int capacity = 0; capacity <= maxCapacity; capacity++) {
                if (item.getWeight() > capacity){
                    continue;
                }

                int excluding = prices[rowIndex - 1][capacity];
                int including = item.getPrice() + prices[rowIndex - 1][capacity - item.getWeight()];

                if (including > excluding){
                    prices[rowIndex][capacity] = including;
                    itemsIncluded[rowIndex][capacity] = true;
                } else {
                    prices[rowIndex][capacity] = excluding;
                }
            }
        }

        int capacity = maxCapacity;
        List<Item> result = new ArrayList<>();

        for (int itemIndex = items.size() - 1; itemIndex >= 0 ; itemIndex--) {
//            if (capacity <= 0){
//                break;
//            }
            if (itemsIncluded[itemIndex + 1][capacity]){
                Item currentItem = items.get(itemIndex);
                result.add(currentItem);
                capacity -= currentItem.getWeight();
            }
        }

        int totalWeight = result.stream().mapToInt(Item::getWeight).sum();

        System.out.println(String.format("Total Weight: %d", totalWeight));
        System.out.println(String.format("Total Value: %d", prices[items.size()][maxCapacity]));

        result.stream()
                .sorted((i1, i2) -> i1.getName().compareTo(i2.getName()))
                .forEach(item -> System.out.println(item.getName()));
    }
}
