import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Character, Integer> characterIntegerMap = readData(new File("huffman.txt"));
        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            MyPriorityQueue.add(entry.getValue(), entry.getKey());
        }
        if (!MyPriorityQueue.isQueueEmpty()) {
            MyPriorityQueue.generateHuffmanCodes();
            Map<Character, String> codes = new TreeMap<>(MyPriorityQueue.getCodes());
            for (Map.Entry<Character, String> entry : codes.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    private static Map<Character,Integer> readData(File f) throws FileNotFoundException {
        Scanner s = new Scanner(f);
        Map<Character,Integer> data = new HashMap<>();
        while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] split = line.split(" ");
                if (split.length == 2) {
                    data.put(split[0].charAt(0), Integer.parseInt(split[1]));
                }
        }
        return data;
    }
    
}
