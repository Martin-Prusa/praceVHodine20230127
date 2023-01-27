package cz.martin.repositories;

import cz.martin.models.UniversitiesCount;
import cz.martin.models.University;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UniversitiesRepository {

    private final String databaseURL = "jdbc:mariadb://localhost/universities?user=root&password=password";

    public List<UniversitiesCount> getCounties() {
        List<UniversitiesCount> countries = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(databaseURL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("""
                    SELECT C.country_name, COUNT(u.id)
                    FROM country AS C JOIN university AS u on C.id = u.country_id
                    GROUP BY C.country_name
                    ORDER BY C.country_name
                """)
                ) {
            while (resultSet.next()) {
                countries.add(new UniversitiesCount(resultSet.getString(1), resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }

    public List<University> getUniversities(String country) {
        List<University> universities = new ArrayList<>();
        try(
                Connection connection = DriverManager.getConnection(databaseURL);
                PreparedStatement statement = connection.prepareStatement("""
                SELECT U.university_name, C.country_name, UY.num_students, UY.student_staff_ratio
                FROM university AS U JOIN country AS C ON C.id = U.country_id
                                    LEFT JOIN university_year AS UY ON UY.year = 2016 AND UY.university_id = U.id
                WHERE C.country_name LIKE ?
""");
                ) {
            statement.setString(1,"%"+country+"%");
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int students = resultSet.getInt(3);
                    universities.add(new University(resultSet.getString(1), resultSet.getString(2), students, (int) (students/resultSet.getDouble(4))));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return universities;
    }
}
