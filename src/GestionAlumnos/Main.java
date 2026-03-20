package GestionAlumnos;

import GestionAlumnos.Model.Alumno;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 7;
        HashMap<String, Alumno> alumnoMap = new HashMap<>();
        List<Alumno> alumnos = new ArrayList<>(List.of(
                new Alumno("123A", "cris", 21, 8.5),
                new Alumno("456B", "ivan", 21, 6.7),
                new Alumno("789C", "gaby", 28, 5.2)

        ));
        for (Alumno alumno : alumnos){
            alumnoMap.put(alumno.getDNI(), alumno);
        }
        do{
            try{
                System.out.print("\nGESTOR DE ALUMNOS"+
                        "\n-------------------------"+
                        "\n- (1) Añadir Alumno"+
                        "\n- (2) Mostrar todos los alumnos"+
                        "\n- (3) Buscar alumno por DNI"+
                        "\n- (4) Modificar nota de un alumno"+
                        "\n- (5) Eliminar alumno"+
                        "\n- (6) Mostrar nota media de todos los alumnos"+
                        "\n- (7) SALIR\n> ")
                ;
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion == 1){
                    Alumno alumno = null;
                    String dni = "", nombre;
                    int edad=0;
                    double notaMedia=0;
                    boolean valido = false;
                    while(!valido){
                        System.out.print("\nInserta el DNI [String]\n> ");
                        dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)){
                            System.out.println("[ERROR]: ESTE DNI YA ESTÁ REGISTRADO");
                        } else {
                            valido = true;
                        }
                    }
                    valido = false;

                    System.out.print("Inserta el nombre [String]\n> ");
                    nombre = sc.nextLine();

                    while(!valido){
                        try{
                            System.out.print("Inserta la EDAD [int]\n> ");
                            edad = sc.nextInt();
                            sc.nextLine();
                            valido = true;
                        } catch (InputMismatchException e){
                            System.out.println("[ERROR]: TIPO INCORRECTO, DEBE SER INTEGER");
                            sc.nextLine();
                        }
                    }
                    valido = false;

                    while(!valido){
                        try{
                            System.out.print("Inserta la NOTA MEDIA [double]\n> ");
                            notaMedia = sc.nextDouble();
                            sc.nextLine();
                            valido = true;
                        } catch (InputMismatchException e){
                            System.out.println("[ERROR]: TIPO INCORRECTO, DEBE SER DOUBLE");
                            sc.nextLine();
                        }
                    }

                    alumno = new Alumno(dni, nombre, edad, notaMedia);
                    alumnoMap.put(alumno.getDNI(), alumno);
                    System.out.println("ALUMNO INSERTADO CORRECTAMENTE");

                } else if (opcion == 2) {
                    if (!(alumnoMap.isEmpty())){
                        System.out.println("\nLISTA DE LOS ALUMNOS REGISTRADOS");
                        for (String dni : alumnoMap.keySet()){
                            System.out.println(alumnoMap.get(dni));
                        }
                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 3) {
                    if (!(alumnoMap.isEmpty())){
                        System.out.print("\nInserta el DNI del alumno: \n> ");
                        String dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)){
                            System.out.println("\nALUMNO\n"+ alumnoMap.get(dni));
                        } else {
                            System.out.println("\n[ERROR]: EL DNI INSERTADO NO ESTÁ REGISTRADO");
                        }

                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 4) {
                    if (!(alumnoMap.isEmpty())){
                        System.out.print("\nInserta el DNI del alumno: \n> ");
                        String dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)){
                            Alumno alumno = alumnoMap.get(dni);
                            double nota = 0;
                            boolean valido = false;
                            while(!valido){
                                try{
                                    System.out.print("Inserta la nueva nota de "+ alumno.getNombre()+ " [double]\n> ");
                                    nota = sc.nextDouble();
                                    sc.nextLine();
                                    valido = true;
                                } catch (InputMismatchException e){
                                    System.out.println("[ERROR]: TIPO INCORRECTO, DEBE SER DOUBLE");
                                    sc.nextLine();
                                }
                            }
                            alumno.setNotaMedia(nota);
                            System.out.println("NOTA MODIFICADA CORRECTAMENTE");

                        } else {
                            System.out.println("\n[ERROR]: EL DNI INSERTADO NO ESTÁ REGISTRADO");
                        }

                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 5) {
                    if (!(alumnoMap.isEmpty())){
                        System.out.print("\nInserta el DNI del alumno a borrar: \n> ");
                        String dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)){
                            alumnoMap.remove(dni);
                            System.out.println("ALUMNO BORRADO CORRECTAMENTE");
                        } else {
                            System.out.println("\n[ERROR]: EL DNI INSERTADO NO ESTÁ REGISTRADO");
                        }

                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 6) {
                    if (!(alumnoMap.isEmpty())){
                        double suma = 0;
                        for (String dni : alumnoMap.keySet()){
                            Alumno alumno = alumnoMap.get(dni);
                            suma += alumno.getNotaMedia();
                        }
                        System.out.println("\nNOTA MEDIA DE LOS ALUMNOS: "+(suma/ alumnoMap.size()));

                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("\n[ERROR]: Tipo INCORRECTO de OPCIÓN");
            }



        } while (opcion != 7);
        System.out.println("Fin del programa.");

    }
}
