package GestionAlumnosV3;

import GestionAlumnosV3.Model.Alumno;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 7;
        TreeMap<String, Alumno> alumnoMap = new TreeMap<>();
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno(
                "123A",
                "Cris",
                new TreeMap<String, Double>(
                        Map.of(
                     "Programación", 8.5,
                     "BBDD", 7.0
                ))));
        alumnos.add(new Alumno(
                "111A",
                "Javi",
                new TreeMap<String, Double>(
                        Map.of(
                                "Programación", 6.5,
                                "BBDD", 6.0
                        ))));
        alumnos.add(new Alumno(
                "222A",
                "Nacho",
                new TreeMap<String, Double>(
                        Map.of(
                                "Programación", 5.5,
                                "BBDD", 3.0
                        ))));
        for (Alumno alumno : alumnos){
            alumnoMap.put(alumno.getDNI(), alumno);
        }
        do{
            try{
                System.out.print("\nGESTOR DE ALUMNOS"+
                        "\n-------------------------"+
                        "\n- (1) AÑADIR Alumno"+
                        "\n- (2) AÑADIR módulo y nota a un Alumno"+
                        "\n- (3) MOSTRAR todos los Alumnos"+
                        "\n- (4) MOSTRAR módulos de un Alumno"+
                        "\n- (5) MOSTRAR media de un Alumno"+
                        "\n- (6) MODIFICAR nota de un módulo"+
                        "\n- (7) ELIMINAR módulo de un Alumno"+
                        "\n- (8) MOSTRAR Alumno con mejor media"+
                        "\n- (9) SALIR\n> ")
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

                    alumno = new Alumno(dni, nombre, new TreeMap<String, Double>());
                    alumnoMap.put(alumno.getDNI(), alumno);
                    for (Alumno a : alumnos){
                        alumnoMap.put(a.getDNI(), a);
                    }
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
                                    String modulo;
                                    double nota;
                                    System.out.print("Escribe el nombre del módulo a INSERTAR [String]\n> ");
                                    do {
                                        modulo = sc.nextLine();
                                    } while (alumno.getModulos().containsKey(modulo));

                                    System.out.print("Escribe la nota a INSERTAR [double]\n> ");
                                    nota = sc.nextDouble();
                                    sc.nextLine();

                                    alumno.getModulos().put(modulo, nota);
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
                            System.out.println("\nMÓDULOS DE "+ alumno.getNombre().toUpperCase()+
                                                "\n-------------------------");
                            for (String modulo : alumno.getModulos().keySet()){
                                System.out.println("- "+modulo+": "+alumno.getModulos().get(modulo));
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
                    if (!alumnoMap.isEmpty()){
                        System.out.print("\nInserta el DNI del Alumno: \n> ");
                        String dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)){
                            Alumno alumno = alumnoMap.get(dni);
                            if (!alumno.getModulos().isEmpty()){
                                System.out.println("\nMÓDULOS DE " + alumno.getNombre().toUpperCase() +
                                        "\n-------------------------");
                                for (String modulo : alumno.getModulos().keySet()){
                                    System.out.println("- " + modulo + ": " + alumno.getModulos().get(modulo));
                                }
                                boolean valido = false;
                                while(!valido){
                                    System.out.print("Inserta el MÓDULO para cambiar su NOTA\n> ");
                                    String modulo = sc.nextLine();
                                    if (alumno.getModulos().containsKey(modulo)){
                                        boolean notaValida = false;
                                        while(!notaValida){
                                            try {
                                                System.out.print("Inserta la NOTA nueva [double]\n> ");
                                                double nota = sc.nextDouble();
                                                sc.nextLine();

                                                alumno.anyadirModuloNota(modulo, nota);

                                                System.out.println("\nNOTA DE " + modulo + " CAMBIADA CORRECTAMENTE");
                                                notaValida = true;
                                                valido = true;

                                            } catch (InputMismatchException e){
                                                System.out.println("[ERROR]: Debes introducir un número");
                                                sc.nextLine();
                                            }
                                        }
                                    } else {
                                        System.out.println("\n[ERROR]: EL MÓDULO INSERTADO NO SE ENCUENTRA EN LA LISTA");
                                    }
                                }
                            } else {
                                System.out.println("\n[ERROR]: NO HAY MÓDULOS REGISTRADOS");
                            }

                        } else {
                            System.out.println("\n[ERROR]: EL DNI INSERTADO NO ESTÁ REGISTRADO");
                        }
                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 7) {
                    if (!alumnoMap.isEmpty()) {
                        System.out.print("\nInserta el DNI del Alumno: \n> ");
                        String dni = sc.nextLine();
                        if (alumnoMap.containsKey(dni)) {
                            Alumno alumno = alumnoMap.get(dni);
                            if (!alumno.getModulos().isEmpty()) {
                                System.out.println("\nMÓDULOS DE " + alumno.getNombre().toUpperCase() +
                                        "\n-------------------------");
                                for (String modulo : alumno.getModulos().keySet()) {
                                    System.out.println("- " + modulo + ": " + alumno.getModulos().get(modulo));
                                }
                                boolean valido = false;
                                while (!valido) {
                                    System.out.print("Inserta el MÓDULO a eliminar\n> ");
                                    String modulo = sc.nextLine();
                                    if (alumno.getModulos().containsKey(modulo)) {
                                        alumno.getModulos().remove(modulo);
                                        System.out.println("MÓDULO DE " + modulo + " BORRADO CORRECTAMENTE");
                                        valido = true;
                                    } else {
                                        System.out.println("\n[ERROR]: EL MÓDULO INSERTADO NO SE ENCUENTRA EN LA LISTA");
                                    }
                                }
                            } else {
                                System.out.println("\n[ERROR]: NO HAY MÓDULOS REGISTRADOS");
                            }

                        } else {
                            System.out.println("\n[ERROR]: EL DNI INSERTADO NO ESTÁ REGISTRADO");
                        }
                    } else {
                        System.out.println("\n[ERROR]: NO HAY ALUMNOS REGISTRADOS");
                    }
                } else if (opcion == 8){
                    if (!(alumnoMap.isEmpty())){
                        Alumno max = alumnos.get(0);
                        for (Alumno alumno : alumnos) {
                            if (alumno.getNotaMedia() > max.getNotaMedia()) max = alumno;
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



        } while (opcion != 9);
        System.out.println("Fin del programa.");
    }
}
