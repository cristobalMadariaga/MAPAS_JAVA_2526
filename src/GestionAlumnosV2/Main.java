package GestionAlumnosV2;

import GestionAlumnosV2.Model.Alumno;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 7;
        HashMap<String, Alumno> alumnoMap = new HashMap<>();
        List<Alumno> alumnos = new ArrayList<>(List.of(
                new Alumno("123A", "cris", new ArrayList<>(List.of(9.0, 8.5))),
                new Alumno("456B", "ivan", new ArrayList<>(List.of(6.0, 7.5, 8.0))),
                new Alumno("789C", "gaby", new ArrayList<>(List.of(5.2)))
        ));
        for (Alumno alumno : alumnos){
            alumnoMap.put(alumno.getDNI(), alumno);
        }
        do{
            try{
                System.out.print("\nGESTOR DE ALUMNOS"+
                        "\n-------------------------"+
                        "\n- (1) AÑADIR Alumno"+
                        "\n- (2) AÑADIR nota a un Alumno"+
                        "\n- (3) MOSTRAR todos los Alumnos"+
                        "\n- (4) MOSTRAR notas de un Alumno"+
                        "\n- (5) MOSTRAR media de un Alumno"+
                        "\n- (6) MOSTRAR Alumno con mejor media"+
                        "\n- (7) SALIR\n> ")
                ;
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion == 1){
                    Alumno alumno = null;
                    String dni = "", nombre;
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

                    System.out.print("Inserta el nombre [String]\n> ");
                    nombre = sc.nextLine();

                    alumno = new Alumno(dni, nombre, new ArrayList<>());
                    alumnoMap.put(alumno.getDNI(), alumno);
                    System.out.println("ALUMNO INSERTADO CORRECTAMENTE");


                } else if (opcion == 2) {
                    if (!(alumnoMap.isEmpty())){
                        System.out.print("\nInserta el DNI del Alumno: \n> ");
                        String dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)){
                            Alumno alumno = alumnoMap.get(dni);
                            boolean valido = false;
                            while(!valido){
                                try{
                                    double nota;
                                    System.out.print("Escribe la nota a INSERTAR [double]\n> ");
                                    nota = sc.nextDouble();
                                    sc.nextLine();

                                    alumno.anyadirNota(nota);
                                    valido = true;
                                } catch (InputMismatchException e){
                                    System.out.println("[ERROR]: TIPO INCORRECTO, DEBE SER DOUBLE");
                                    sc.nextLine();
                                }
                            }
                            System.out.println("NOTA INSERTADA CORRECTAMENTE");
                        } else {
                            System.out.println("\n[ERROR]: EL DNI INSERTADO NO ESTÁ REGISTRADO");
                        }

                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 3) {
                    if (!(alumnoMap.isEmpty())){
                        System.out.println("\nLISTA DE ALUMNOS");
                        for (String dni : alumnoMap.keySet()){
                            Alumno alumno = alumnoMap.get(dni);
                            System.out.println(alumno);
                        }

                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 4) {
                    if (!(alumnoMap.isEmpty())){
                        System.out.print("\nInserta el DNI del Alumno: \n> ");
                        String dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)){
                           Alumno alumno = alumnoMap.get(dni);
                            System.out.println("\nNOTAS DE "+ alumno.getNombre().toUpperCase()+
                                                "\n-------------------------");
                            for (double nota : alumno.getNotas()){
                                System.out.println("- "+nota);
                            }

                        } else {
                            System.out.println("\n[ERROR]: EL DNI INSERTADO NO ESTÁ REGISTRADO");
                        }

                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 5) {
                    if (!(alumnoMap.isEmpty())){
                        System.out.print("\nInserta el DNI del Alumno: \n> ");
                        String dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)){
                            Alumno alumno = alumnoMap.get(dni);
                            System.out.println("MEDIA DE "+ alumno.getNombre().toUpperCase()+ ": "+alumno.getNotaMedia());
                        } else {
                            System.out.println("\n[ERROR]: EL DNI INSERTADO NO ESTÁ REGISTRADO");
                        }

                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 6) {
                    if (!(alumnoMap.isEmpty())){
                        Alumno max = null;
                        int i = 0;
                        for (String dni : alumnoMap.keySet()){
                            Alumno alumno = alumnoMap.get(dni);
                            if (i == 0){
                                max = alumno;
                            }
                            if (alumno.getNotaMedia() > max.getNotaMedia()) max = alumno;
                            i++;
                        }
                        System.out.println("ALUMNO CON MEJOR MEDIA");
                        System.out.println(max);
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
