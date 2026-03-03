package Lab3;

// Fractional Knapsack

import java.util.Arrays;
import java.util.Comparator;

public class Q5 {

    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static double getMaxValue(Item[] items, int capacity) {

        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double r1 = (double) a.value / a.weight;
                double r2 = (double) b.value / b.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {

            if (capacity == 0)
                break;

            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                double fraction = (double) capacity / item.weight;
                totalValue += item.value * fraction;
                capacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {

        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);

        System.out.println("Maximum value in knapsack = " + maxValue);
    }
}