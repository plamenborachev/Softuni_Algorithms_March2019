package greedy_algorithms.p01_fractionalKnapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Item {
        private double price;
        private double weight;

        Item(double price, double weight) {
            this.price = price;
            this.weight = weight;
        }

        double getPrice() {
            return this.price;
        }

        double getWeight() {
            return this.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double capacity = Double.parseDouble(reader.readLine().split("\\s+")[1]);
        double itemsCount = Double.parseDouble(reader.readLine().split("\\s+")[1]);

        List<Item> items = new ArrayList<Item>();

        for (int i = 0; i < itemsCount; i++) {
            String[] itemTokens = reader.readLine().split(" -> ");
            double price = Double.parseDouble(itemTokens[0]);
            double weight = Double.parseDouble(itemTokens[1]);
            items.add(new Item(price, weight));
        }

        items.sort((i1, i2) -> Double.compare(i2.getPrice() / i2.getWeight(), i1.getPrice() / i1.getWeight()));

        double totalPrice = 0d;
        StringBuilder sb = new StringBuilder();

        for (Item item : items) {
            if (capacity == 0) {
                break;
            }
            if (capacity >= item.getWeight()) {
                totalPrice += item.getPrice();
                capacity -= item.getWeight();
                sb.append(String.format("Take 100%% of item with price %.2f and weight %.2f",
                        item.getPrice(), item.getWeight()))
                        .append(System.lineSeparator());
            } else {
                double ratio = capacity / item.getWeight();
                totalPrice += item.getPrice() * ratio;
                capacity -= item.getWeight() * ratio;
                sb.append(String.format("Take %.2f%% of item with price %.2f and weight %.2f",
                        ratio * 100, item.getPrice(), item.getWeight()))
                        .append(System.lineSeparator());
            }
        }

        System.out.println(sb.toString().trim());
        System.out.println(String.format("Total price: %.2f", totalPrice));
    }
}
