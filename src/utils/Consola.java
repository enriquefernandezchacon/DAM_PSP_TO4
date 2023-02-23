package utils;

public class Consola {

    //Impedimos instanciar la clase, solo accedermos a sus metodos
    private Consola() {
    }

    //Metodo para presentar el programa
    public static void presentarPrograma() {
        System.out.println("Programa para conectarse a servidores FTP");
    }

    //Metodo para mostrar el menu
    public static void imprimirMenu() {
        System.out.println("1. Listar servidor de la universidad de Valenica");
        System.out.println("2. Listar servidor de la universidad de Navarra");
        System.out.println("3. Listar servidor de FreeBSD");
        System.out.println("4. Iniciar sesion en servidor local");
        System.out.println("5. Salir");
    }

    //Metodo para recibir la eleccion del menu
    public static int recibirOpcion() {
        int opcion;
        System.out.print("Ingrese una opcion: ");
        opcion = Entrada.entero();
        return opcion;
    }

    //Metodo para solicitar al usuario datos para el login
    public static String[] solicitarDatosLogin() {
        String[] datos = new String[3];
        System.out.print("Ingrese el usuario: ");
        datos[0] = Entrada.cadena();
        System.out.print("Ingrese la contrasena: ");
        datos[1] = Entrada.cadena();
        return datos;
    }

    //Metodos para imprimir los distintos tipos de mensajes
    public static void imprimirArchivo(String mensaje) {
        System.out.println("ARCHIVO:" + mensaje);
    }

    public static void imprimirDirectorio(String mensaje) {
        System.out.println("DIRECTORIO:" + mensaje);
    }

    public static void imprimirError(String servidor) {
        System.err.println("ERROR: No se ha podido contactar con el servidor: " + servidor);
    }
}
