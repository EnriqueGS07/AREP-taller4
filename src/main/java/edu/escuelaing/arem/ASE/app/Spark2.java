package edu.escuelaing.arem.ASE.app;


import java.util.HashMap;

public class Spark2 {

    private HashMap<String, String> services1 = new HashMap<>();
    private HashMap<String, String> services2 = new HashMap<>();

    private static Spark2 spark2;


    public static Spark2 getInstance(){
        if(spark2 == null){
            spark2 = new Spark2();
        }
        return spark2;
    }

    public HashMap<String, String> getServices() {
        return services1;
    }

    public HashMap<String, String> getServices2() {
        return services2;
    }

    /**
     * Guarda el recurso
     * @param handler
     * @param path
     */
    public void get(RouteHandler handler, String path){
        String response = handler.handler(new Response());
        services1.put(path, response);
    }

    public void post(RouteHandler handler, String path){
        String response = handler.handler(new Response());
        services2.put(path, response);
    }


}
