package GestionAlumnosV3.Model;

import java.util.List;
import java.util.TreeMap;

public class Alumno {
    private String dni, nombre;
    private List<Double> notas;
    private TreeMap<String, Double> modulos;
    public Alumno(String dni, String nombre, List<Double> notas){
        this.dni = dni;
        this.nombre = nombre;
        this.notas = notas;
    }
    // Getters
    public String getDNI(){
        return dni;
    }
    public String getNombre(){
        return nombre;
    }
    public List<Double> getNotas(){
        return notas;
    }

    // Setters
    public void setDNI(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void anyadirNota(double nota){
        notas.add(nota);
    }
    public double getNotaMedia(){
        double suma = 0;
        for (double nota : notas){
            suma+=nota;
        }
        return suma/notas.size();
    }
    @Override
    public String toString(){
        return "------------------------"+
                "\n- DNI: " + dni +
                "\n- Nombre: " + nombre +
                "\n- Nota media: " + getNotaMedia()+
                "\n- Notas: "+ notas;
    }
}
