import java.io.*;
import java.util.TreeMap;
import java.util.*;

public class P3Transportes {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Camion> vehiculos;
        int opcion;


        File fichero= new File("flota.dat");
        if(!fichero.exists()){
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("flota.dat"))) {
                vehiculos=new TreeMap<>();
                oos.writeObject(vehiculos);
            }
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            vehiculos = (TreeMap<String, Camion>) ois.readObject();
            do {

                menu();
                 opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        while (true) {
                            String nombreEmpresa;
                            int capacidad;
                            System.out.println("Introduzca la matricula: (Fin=Salir)");
                            String matricula = sc.next();
                            if (matricula.equalsIgnoreCase("fin")) {
                                break;
                            } else {
                                if (vehiculos.containsKey(matricula)) {
                                    System.out.println(vehiculos.get(matricula));
                                    System.out.println("Quieres eliminarlo (1=si,2=no)");
                                    int eliminar = sc.nextInt();
                                    if (eliminar == 1) {
                                        vehiculos.remove(matricula);
                                    }
                                } else {
                                    System.out.println("Nombre de la empresa: ");
                                    nombreEmpresa = sc.next();
                                    System.out.println("Capacidad: ");
                                    capacidad = sc.nextInt();
                                    Camion c = new Camion(nombreEmpresa, capacidad);
                                    vehiculos.put(matricula, c);
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Listado de la flota");
                        for (Map.Entry<String, Camion> s : vehiculos.entrySet()) {
                            System.out.println(s);
                        }
                        break;
                    case 3:
                        vehiculos.clear();
                        System.out.println("Flota Eliminada");
                        break;
                    case 4:
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("flota.dat"))) {
                            oos.writeObject(vehiculos);
                        }
                        break;

                }

            }while(opcion!=4);


        }
    }

    static void menu() {
        System.out.println("Menu principal");
        System.out.println("---------------");
        System.out.println("1. Gestionar matriculas");
        System.out.println("2. Listar flota");
        System.out.println("3. Eliminar todos los camiones");
        System.out.println("4.Salir");
    }

}
