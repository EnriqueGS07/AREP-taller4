package edu.escuelaing.arem.ASE.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que hace de servidor web y ser la fachada para que el usuario interactue con la aplicacion
 */
public class HttpServer {


    private static HttpServer _instance = new HttpServer();
    private HashMap<String, String> services = new HashMap<>();
    private OutputStream outputStream;

    /**
     * Metodo que devuelve una instancia unica del servidor http
     * @return instancia del servidor
     */
    public static HttpServer getInstance() {
        return _instance;
    }

    /**
     * Metodo que ejecuta un servicio
     * @param service servicio que se desea ejecutar
     * @return respuesta del servicio header y cuerpo de la peticion
     */
//    private String executeService(String service) {
//        Service rs = services.get(service);
//        String header = rs.getHeader();
//        String body = rs.getResponse();
//        return header + body;
//    }

    /**
     * Metodo que agrega un servicio a la lista de servicios
     * @param key nombre del servicio
     * @param service servicio a agregar
     */
//    public void addService(String key, Service service) {
//        services.put(key, service);
//    }

    /**
     * Metodo para empezar a correr el servidor http
     * @throws IOException
     */
    public void run(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        String className = args[0];
        //Cargar clase con forname
        Class<?> c = Class.forName(args[0]);
        //Extraer los metodos con requestMapping
        Method[] met = c.getMethods();
        for (Method m: met) {
            if (m.isAnnotationPresent(RequestMapping.class)){
                String llave = m.getAnnotation(RequestMapping.class).value();
                String s = (String) m.invoke(null);
                services.put(llave, s);

            }
        }

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while(running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            outputStream = clientSocket.getOutputStream();
            String inputLine, outputLine, requestType = "GET";

            boolean first_line = true;
            String request = "/simple";
            while ((inputLine = in.readLine()) != null) {
                if (first_line) {
                    request = inputLine.split(" ")[1];
                    requestType = inputLine.split(" ")[0];
                    first_line = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }

//            HashMap<String, String> services = spark2.getServices();

            System.out.println("AAAAAA" + request);
            if(!services.containsKey(request)){
                outputLine = "";
            }
            else if (requestType.equals("GET")) {
                outputLine = services.get(request);

            }else if (request.startsWith("/apps/") && requestType.equals("POST")) {
                outputLine = "";
            }
            else{
                outputLine = "HTTP/1.1 200 OK\r\n" +
                        "Content-type: text/html\r\n" +
                        "\r\n" +
                        "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>Title of the document</title>\n"
                        + "</head>"
                        + "<body>"
                        + "My Web Site"
                        + "</body>"
                        + "</html>";
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }
}
