package Lab3;

import java.util.*;

public class Q6 {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static void generateCodes(Node root, String code,
                                     Map<Character, String> huffmanCodes) {

        if (root == null)
            return;

        // Leaf node
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.ch, code);
        }

        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    public static void main(String[] args) {

        String text = "huffmanencoding";

        // Step 1: Frequency map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Min-heap
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Step 3–5: Build tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node merged = new Node('\0', left.freq + right.freq);
            merged.left = left;
            merged.right = right;

            pq.add(merged);
        }

        Node root = pq.poll();

        // Step 6–7: Generate codes
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}