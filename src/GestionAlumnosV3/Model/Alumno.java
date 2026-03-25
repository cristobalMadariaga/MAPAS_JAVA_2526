package GestionAlumnosV3.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Alumno {
    private String dni, nombre;
    private List<Double> notas;
    private TreeMap<String, Double> modulos;
    public Alumno(String dni, String nombre, TreeMap<String, Double> modulos){
        this.dni = dni;
        this.nombre = nombre;
        this.modulos = modulos;
        this.notas = getNotas();
    }
    // Getters
    public String getDNI(){
        return dni;
    }
    public String getNombre(){
        return nombre;
    }
    public TreeMap<String, Double> getModulos(){
        return modulos;
    }
    public List<Double> getNotas(){
        List<Double> notas = new ArrayList<>();
        for (String modulo : modulos.keySet()){
            notas.add(modulos.get(modulo));
        }
        return notas;
    }
    // Setters
    public void setDNI(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void anyadirModuloNota(String modulo, double nota){
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
                "\n- Modulos: "+ modulos;
    }
}
