import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class P2ListarReservas {
    public static void main(String[] args) {
        File fichero = new File("reservas.dat");
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
            raf.seek(0);
            int cont = 0;

            for (int i = 0; i < 31; i++) {
                int inv = raf.readInt();
                if (inv >=0) {
                    System.out.printf("Dia %d: %d\n", i+1, inv);
                    cont++;
                }
            }
            System.out.println("Hay " + cont + " aperturas este mes");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
