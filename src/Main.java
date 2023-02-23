import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import utils.Consola;

public class Main {

    private static final String SERVER_UV = "ftp.uv.es";
    private static final String SERVER_FREEBSD = "ftp.freebsd.org";
    private static final String SERVER_UNAVARRA = "ftp.unavarra.es";
    private static final String SERVER_LOCAL = "localhost";
    private static final int PORT = 21;
    private static final String USERNAME = "anonymous";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        int opcion;
        do {
            Consola.presentarPrograma();
            Consola.imprimirMenu();
            opcion = Consola.recibirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> contectarFTP(SERVER_UV, USERNAME, PASSWORD);
            case 2 -> contectarFTP(SERVER_UNAVARRA, USERNAME, PASSWORD);
            case 3 -> contectarFTP(SERVER_FREEBSD, USERNAME, PASSWORD);
            case 4 -> {
                String[] datos = Consola.solicitarDatosLogin();
                contectarFTP(SERVER_LOCAL, datos[0], datos[1]);
            }
            case 5 -> System.out.println("Hasta luego!");
            default -> System.out.println("Opcion no valida");
        }
    }

    private static void contectarFTP(String servidor, String usuario, String contrasena) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(servidor, PORT);
            ftpClient.login(usuario, contrasena);
            FTPFile[] files = ftpClient.listFiles("/");
            for (FTPFile file : files) {
                if (file.isDirectory()) {
                    Consola.imprimirDirectorio(file.getName());
                } else {
                    Consola.imprimirArchivo(file.getName());
                }
            }
            ftpClient.logout();
        } catch (IOException e) {
            Consola.imprimirError(servidor);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                Consola.imprimirError(servidor);
            }
        }
    }
}