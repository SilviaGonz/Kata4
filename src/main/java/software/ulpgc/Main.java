package software.ulpgc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    /* kata2
    public static void main(String[] args) {
        TsvFileGradesLoader loader = new TsvFileGradesLoader(new File("grades.txt"));
        List<Grades> grades = loader.load();
        for (Grades grade : grades) {
            System.out.println("El estudiante con código " + grade.getNum_Estudiante() + " obtuvo un " + grade.getCalificacion() + " en la asignatura " + grade.getAsignatura());
        }
    }
     */
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(urlOf("grades.db"))) {
            SqliteGradesLoader sqliteGradesLoader = new SqliteGradesLoader(connection);
            List<Grades> grades = sqliteGradesLoader.loadAdd();
            for (Grades grade : grades) {
                System.out.println(grade);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String urlOf(String filename) {
        return "jdbc:sqlite:" + filename;
    }
}
