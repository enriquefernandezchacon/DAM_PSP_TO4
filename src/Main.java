

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ftp();
    }

    //Conéctate a ftp.uv.es y visualiza los directorios del directorio raíz, entra después en cada directorio del directorio raíz mostrando la lista de ficheros y directorios que hay. Prueba en otros servidores FTP que admiten usuarios anónimos como, ftp.freebsd.org, ftp.unavarra.es, y pon otros ejemplos que encuentres por internet.

    private static void ftp() {
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect("ftp.uv.es");
            ftp.login("anonymous", "anonymous");
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            String[] names = ftp.listNames();
            for (String name : names) {
                System.out.println(name);
            }
            ftp.logout();
            ftp.disconnect();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}