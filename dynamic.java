import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    String name;
    int worth;
    int weight;

    public Item(String name, int worth, int weight) {
        this.name = name;
        this.worth = worth;
        this.weight = weight;
    }
}

public class dynamic {
    public static List<Item> dynamicKnapsack(List<Item> items, int weightLimit) {
        int n = items.size();
        int[][] dp = new int[n + 1][weightLimit + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= weightLimit; w++) {
                Item item = items.get(i - 1);
                if (item.weight <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - item.weight] + item.worth);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int totalWeight = weightLimit;
        int totalWorth = dp[n][weightLimit];
        List<Item> knapsack = new ArrayList<>();
        for (int i = n; i > 0 && totalWorth > 0; i--) {
            if (dp[i][totalWeight] != dp[i - 1][totalWeight]) {
                Item item = items.get(i - 1);
                knapsack.add(item);
                totalWorth -= item.worth;
                totalWeight -= item.weight;
            }
        }

        return knapsack;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Lenovo X1 Carbon (5th Gen)", 40, 112));
        items.add(new Item("10 pairs thongs", 39, 80));
        items.add(new Item("5 Underarmour Strappy", 38, 305));
        items.add(new Item("1 pair Uniqlo leggings", 37, 185));
        items.add(new Item("2 Lululemon Cool Racerback", 36, 174));
        items.add(new Item("Charges and cables in Mini Bomber Travel Kit", 35, 665));
        items.add(new Item("The Roost Stand", 34, 170));
        items.add(new Item("ThinkPad Compact Bluetooth Keyboard with trackpoint", 33, 460));
        items.add(new Item("Seagate Backup PlusSlim", 32, 159));
        items.add(new Item("1 pair black denim shorts", 31, 197));
        items.add(new Item("2 pairs Nike Pro shorts", 30, 112));
        items.add(new Item("2 pairs Lululemon shorts", 29, 184));
        items.add(new Item("Isabella T-Strap Croc sandals", 28, 200));
        items.add(new Item("2 Underarmour HeatGear CoolSwitch tank tops", 27, 138));
        items.add(new Item("5 pairs black socks", 26, 95));
        items.add(new Item("2 pairs Injinji Women's Run Lightweight No-Show Toe Socks", 25, 54));
        items.add(new Item("1 fancy tank top", 24, 71));
        items.add(new Item("1 light and stretchylong-sleeve shirt (Gap Fit)", 23, 147));
        items.add(new Item("Uniqlo Ultralight Down insulating jacket", 22, 235));
        items.add(new Item("Patagonia Torrentshell", 21, 301));
        items.add(new Item("Lightweight Merino Wool Buff", 20, 50));
        items.add(new Item("1 LBD (H&M)", 19, 174));
        items.add(new Item("Field Notes Pitch Black Memo Book Dot-Graph", 18, 68));
        items.add(new Item("Innergie PocketCell USB-C 6000mAh power bank", 17, 14));
        items.add(new Item("Important papers", 16, 228));
        items.add(new Item("Deuter First Aid Kit Active", 15, 144));
        items.add(new Item("Stanley Classic Vacuum Camp Mug 16oz", 14, 454));
        items.add(new Item("JBL Reflect Mini Bluetooth Sport Headphones", 13, 14));
        items.add(new Item("Anker SoundCore nano Bluetooth Speaker", 12, 89));
        items.add(new Item("Oakley Latch Sunglasses", 11, 30));
        items.add(new Item("Ray Ban Wayfarer Classic", 10, 45));
        items.add(new Item("Zip bag of toiletries", 9, 236));
        items.add(new Item("Petzl E+LITE Emergency Headlamp", 8, 27));
        items.add(new Item("Laptop Bag", 7, 20));
        items.add(new Item("Peak Design Cuff Camera Wrist Strap", 6, 26));
        items.add(new Item("Travelon Micro Scale", 5, 125));
        items.add(new Item("BlitzWolf Bluetooth Tripod/Monopod", 4, 150));
        items.add(new Item("Humangear GoBites Duo", 3, 22));
        items.add(new Item("Touchlight", 2, 10));
        items.add(new Item("Vapur Bottle 1L", 1, 41));
        System.out.print("Enter the maximum weight of items: ");
        int weightLimit = scanner.nextInt();
        //int weightLimit = 7000;
        long startTime = System.nanoTime(); // Start time measurement
        List<Item> knapsack = dynamicKnapsack(items, weightLimit);
        long endTime = System.nanoTime(); // End time measurement

        System.out.println("\nDynamic Programming:");
        System.out.println("Items in knapsack:");
        int totalWeight = 0;
        int totalWorth = 0;
        for (Item item : knapsack) {
            System.out.println(item.name + " (" + item.worth + ", " + item.weight + ")");
            totalWeight += item.weight;
            totalWorth += item.worth;
        }
        System.out.println("\n------------Summary Dynamic Algorithm--------------------");
        System.out.println("Total worth of items in knapsack: " + totalWorth);
        System.out.println("Total weight of items in knapsack: " + totalWeight + " grams");

        long duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
        System.out.println("Execution time: " + duration + " milliseconds");

        scanner.close(); // Close scanner to prevent resource leak
    }
}
