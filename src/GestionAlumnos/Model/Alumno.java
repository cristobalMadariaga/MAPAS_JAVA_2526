package GestionAlumnos.Model;

public class Alumno {
    private String dni, nombre;
    private int edad;
    private double notaMedia;

    public Alumno(String dni, String nombre, int edad, double notaMedia){
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }
    // Getters
    public String getDNI(){
        return dni;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public double getNotaMedia(){
        return notaMedia;
    }

    // Setters
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString(){
        return "------------------------"+
                "\n- DNI: " + dni +
                "\n- Nombre: " + nombre +
                "\n- Edad: " + edad +
                "\n- Nota media: " + notaMedia;
    }
}
