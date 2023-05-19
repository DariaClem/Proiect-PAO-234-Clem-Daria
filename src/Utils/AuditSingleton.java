package Utils;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum AuditSingleton {
    INSTANCE;

    private final String auditFile = "CSVFiles/audit.csv";
    private final DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

    public void writeAction(String actionName) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(auditFile, true))) {
            String line = actionName + "," + LocalDateTime.now().format(timeStamp);
            printWriter.println(line);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
