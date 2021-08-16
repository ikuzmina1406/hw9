package ua.GoIT.modul9;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Words {
    public static void main(String[] args) throws IOException {
        File file = new File("words.txt");
        InputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);
        String message = "";
        while (scanner.hasNext()) {
            message = scanner.nextLine();

        }
        scanner.close();
        inputStream.close();


        String[] words = message.toLowerCase().replaceAll("[-.?!)(,:]", "").split("\\s");

        Map<String, Integer> counterMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                Integer count = counterMap.get(word);
                if (count == null) {
                    count = 0;
                }
                counterMap.put(word, ++count);
            }
        }
        Map<String, Integer> sorted = counterMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        for (String word : sorted.keySet()) {
            System.out.println(word + ": " + sorted.get(word));
        }
    }
}
