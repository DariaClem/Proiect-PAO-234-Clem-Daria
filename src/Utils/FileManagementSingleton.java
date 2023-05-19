package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public enum FileManagementSingleton {
    INSTANCE;

    public List<String[]> readFromCsv(String fileName) {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] words;
            AuditSingleton.INSTANCE.writeAction("Read from CSV file " + fileName);
            while ((line = bufferedReader.readLine()) != null) {
                words = line.split(",");
                lines.add(words);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return lines;
    }

    public String convertToCsv(String[] item) {
        return String.join(",", item);
    }

    public void writeInCsv(String fileName, List<String[]> content) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
            content.stream()
                    .map(this::convertToCsv)
                    .sorted()
                    .forEach(printWriter::println);
            AuditSingleton.INSTANCE.writeAction("Write in CSV file " + fileName);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void writeInCsv(String fileName, String content) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
            printWriter.println(content);
            AuditSingleton.INSTANCE.writeAction("Write in CSV file " + fileName);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
