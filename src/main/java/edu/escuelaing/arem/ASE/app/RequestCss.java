package edu.escuelaing.arem.ASE.app;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class RequestCss {

    /**
     * Metodo que retorna un header y cuerpo con status ok del tipo css
     * @return Header y body del css HTTP status ok
     */
    @RequestMapping("/styles.css")
    public static String css(){
        String header = "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/css\r\n" +
                "\r\n";
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get("src/main/resources/styles.css"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return header + new String(fileContent);
    }
}
