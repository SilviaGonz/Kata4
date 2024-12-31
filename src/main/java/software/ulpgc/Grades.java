package software.ulpgc;

public record Grades(String num_Estudiante, String calificacion, String asignatura)  {
    /* kata2
    private final int Num_Estudiante;
    private final String Calificacion;
    private final String Asignatura;

    public Grades(String num_Estudiante, String calificacion, String asignatura) {
        Num_Estudiante = Integer.parseInt(num_Estudiante);
        Calificacion = calificacion;
        Asignatura = asignatura;
    }

    public int getNum_Estudiante() {
        return Num_Estudiante;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public String getAsignatura() {
        return Asignatura;
    }
     */
}
