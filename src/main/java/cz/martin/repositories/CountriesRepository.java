package cz.martin.repositories;

import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CountriesRepository {

    private final String databaseURL = "jdbc:mariadb://localhost/universities?user=root&password=password";

    public List<String> getCounties() {
        List<String> countries = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(databaseURL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("""
                    SELECT DISTINCT C.country_name
                    FROM country as C
                    ORDER BY C.country_name
                """)
                ) {
            while (resultSet.next()) {
                countries.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }
}
