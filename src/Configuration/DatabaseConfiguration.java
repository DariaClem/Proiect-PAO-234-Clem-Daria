package Configuration;

import Utils.FileManagementSingleton;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseConfiguration {
    INSTANCE;
    private final Connection databaseConnection;

    DatabaseConfiguration(Connection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    DatabaseConfiguration() {
        try {
            // Funcția readFromCsv returnează List<String[]>, asa încât selectez doar prima valoare
            String[] dbInfo = FileManagementSingleton.INSTANCE.readFromCsv("databaseFiles/databaseConnectionFile").get(0);
            String url = dbInfo[0];
            String username = dbInfo[1];
            String pass = dbInfo[2];
            databaseConnection = DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return databaseConnection;
    }
}
