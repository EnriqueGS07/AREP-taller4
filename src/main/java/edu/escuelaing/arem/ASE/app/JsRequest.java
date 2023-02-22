package edu.escuelaing.arem.ASE.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class JsRequest {

    /**
     * Metodo que retorna un header y cuerpo con status ok del tipo javascript
     * @return Header y body del js HTTP status ok
     */
    @RequestMapping("/app.js")
    public static String js(){
        String header = "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/javascript\r\n" +
                "\r\n";
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get("src/main/resources/app.js"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return header + new String(fileContent);
    }
}

