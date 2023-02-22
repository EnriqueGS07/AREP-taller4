package edu.escuelaing.arem.ASE.app;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    /**
     * Metodo que agrega los servicios y corre el servidor
     * @param args
     * @throws IOException
     */
        public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
            HttpServer server = HttpServer.getInstance();
            server.run(args);
        }

}
