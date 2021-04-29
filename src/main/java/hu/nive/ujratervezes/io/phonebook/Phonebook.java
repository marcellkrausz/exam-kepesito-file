package hu.nive.ujratervezes.io.phonebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Phonebook {

    public static void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
                bw.write(mapToString(contacts));
            } catch (IOException a) {
                System.out.println(a.getMessage());
            }
        }
    }

    public static String mapToString(Map<String, String> contacts) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}