package software.ulpgc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SqliteGradesLoader implements GradesLoader {
    private final Connection connection;
    private final static String URL = "SELECT Grades.Num_Estudiante, Grades.Calificacion, Grades.Asignatura FROM Grades";

    public SqliteGradesLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Grades> loadAdd() {
        try {
            return load(queryAll());
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    private List<Grades> load(ResultSet resultSet) throws SQLException {
        List<Grades> grades = new ArrayList<>();
        while (resultSet.next()) {
            grades.add(gradesOf(resultSet));
        }
        return grades;
    }

    private Grades gradesOf(ResultSet resultSet) throws SQLException {
        return new Grades(
                resultSet.getString("Num_Estudiante"),
                resultSet.getString("Calificacion"),
                resultSet.getString("Asignatura")

        );
    }

    private ResultSet queryAll() throws SQLException {
        return connection.createStatement().executeQuery(URL);
    }
}
