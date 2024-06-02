
import java.util.*;

class Node {
    int data;
    char c;

    Node left;
    Node right;
}
class MyComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.data - y.data;
    }
}
public class MyPriorityQueue {
    private static PriorityQueue<Node> queue = new PriorityQueue<>(new MyComparator());
    private static final ArrayList<Integer> numbers = new ArrayList<>();
    private static final ArrayList<Character> characters = new ArrayList<>();
    private static Map<Character, String> codes = new HashMap<>();

    public static void add(int num, char character) {
        Node node = new Node();
        node.c = character;
        node.data = num;

        node.left = null;
        node.right = null;

        queue.add(node);
        characters.add(character);
        numbers.add(num);
    }
    public static void printCodes(Node root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            codes.put(root.c, s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void generateHuffmanCodes() {
        Node x, y;
        Node root = null;

        while (queue.size() > 1) {
            x = queue.peek();
            queue.poll();

            y = queue.peek();
            queue.poll();

            Node f = new Node();

            f.data = x.data + y.data;
            f.c = '-';

            f.left = x;
            f.right = y;

            root = f;

            queue.add(f);
        }
        printCodes(root, "");
    }
    public static Map<Character, String> getCodes() {
        return codes;
    }
    public static boolean isQueueEmpty() {
        return queue.isEmpty();
    }

}
