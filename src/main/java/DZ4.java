import java.util.*;

public class DZ4 {

    public static void main(String[] args) {
        String[] words = {"hello", "Hello", "car", "boy", "world", "World", "hi", "bye", "Bye", "bye"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println();

        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println();

        Phonebook phonebook = new Phonebook();

        phonebook.add(2304578, "Ivanov");
        phonebook.add(5678794, "Ivanov");
        phonebook.add(3456783, "Petrov");
        phonebook.add(3456278, "Sidorov");
        phonebook.add(9786053, "Sidorov");
        phonebook.add(6475893, "Sidorov");

        phonebook.get("Ivanov");
        phonebook.get("Petrov");
        phonebook.get("Sidorov");
        phonebook.get("Akulshin");
    }

}
