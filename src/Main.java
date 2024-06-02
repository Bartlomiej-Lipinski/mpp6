import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (isFileValid(new File("huffman.txt"))){
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
        }else {
            System.out.println("Invalid file");
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
    public static boolean isFileValid(File f) throws FileNotFoundException {
        boolean valid = true;
        Scanner s = new Scanner(f);
        int i = 0;
        int n = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] split = line.split(" ");
            if(i==0){
                n = Integer.parseInt(split[0]);
            }
            if (split.length != 1 && i == 0 && !split[0].matches("[0-9]+")) {
                return false;
            }
            if (split.length != 2 && i>0 && !split[0].matches("[a-zA-Z]+") && !split[1].matches("[0-9]+")){
                return false;
            }
            i++;
        }
        if((i-1)!=n){
            return false;
        }
        return valid;
    }
}
