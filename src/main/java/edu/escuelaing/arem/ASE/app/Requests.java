package edu.escuelaing.arem.ASE.app;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class Requests {

    /**
     * Metodo que retorna un header y cuerpo con status ok del tipo html
     * @return Header y body del html HTTP status ok
     */
    @RequestMapping("/index.html")
    public static String html(){
        String header = "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/html\r\n" +
                "\r\n";
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get("src/main/resources/index.html"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return header + new String(fileContent);
    }
}
