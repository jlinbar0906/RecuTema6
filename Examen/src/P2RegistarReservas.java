import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class P2RegistarReservas {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File fichero = new File("reservas.dat");
        if (!fichero.exists()) {
            System.out.println("Inicializando reservas");
            try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
                for (int i = 0; i < 31; i++) {
                    raf.writeInt(-1);
                }
            }
        }else{
            System.out.println("Abriendo reservas");
        }
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            while(true){
                int inv=0;
                System.out.println("Dia: (1-31)(0=salir)");
                int dia=sc.nextInt();
                if(dia>=1 && dia<=31){
                    while(true){
                    raf.seek(Integer.BYTES *(dia-1));
                    int aux=raf.readInt();
                        if(aux==-1){
                            System.out.println("¿Cuantos invitados nuevos:");
                            inv=sc.nextInt();
                            if(inv>=1){
                                raf.seek(Integer.BYTES *(dia-1));
                                raf.writeInt(inv);
                                System.out.println("reserva añadida");
                                break;
                            }else{
                                System.out.println("Numero incorrecto");
                            }
                    }else{
                            System.out.println("Invitados actuales: " + aux);
                            System.out.println("¿Cuantos invitados nuevos:");
                            inv=sc.nextInt();
                            if(inv>=1){
                                raf.seek(Integer.BYTES *(dia-1));
                                raf.writeInt(inv +aux);
                                System.out.println("reserva añadida");
                                break;
                            }else{
                                System.out.println("Numero incorrecto");
                            }
                        }
                    }
                }else if(dia==0){
                    break;
                }else{
                    System.out.println("Dia incorrecto.");
                }
            }

        }
    }
}
