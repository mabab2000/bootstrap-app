package net.evs.evs_application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseTest implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        testConnection();
    }

    public void testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
