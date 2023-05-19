package Utile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public enum GestionareFisiereSingleton {
    INSTANCE;

    public List<String[]> readFromCsv(String fileName) {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] tempArr;
            AuditSingleton.INSTANCE.writeAction("Read from CSV file " + fileName);
            while ((line = bufferedReader.readLine()) != null) {
                tempArr = line.split(",");
                lines.add(tempArr);
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
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            content.stream()
                    .map(this::convertToCsv)
                    .sorted()
                    .forEach(printWriter::println);
            AuditSingleton.INSTANCE.writeAction("Write in CSV file " + fileName);
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
