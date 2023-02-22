import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class Simple {

    public void run() {
        String server = "ftp.uv.es";
        int port = 21;
        String username = "anonymous";
        String password = "";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            FTPFile[] files = ftpClient.listFiles("/");
            for (FTPFile file : files) {
                System.out.println(file.getName());
                if (file.isDirectory()) {
                    listFiles(ftpClient, file.getName());
                }
            }
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void listFiles(FTPClient ftpClient, String path) throws IOException {
        FTPFile[] files = ftpClient.listFiles(path);
        for (FTPFile file : files) {
            System.out.println(path + "/" + file.getName());
            if (file.isDirectory()) {
                listFiles(ftpClient, path + "/" + file.getName());
            }
        }
    }
}
