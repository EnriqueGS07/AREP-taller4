package edu.escuelaing.arem.ASE.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Response {
    private String type;
    private String respondeCode;
    private String route;

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRuote() {
        return "src/main/resources"+ route;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRespondeCode() {
        return respondeCode;
    }

    public void setRespondeCode(String respondeCode) {
        this.respondeCode = respondeCode;
    }



    public String getHeader() {
        return "HTTP/1.1"+ getRespondeCode() +"\r\n" +
                "Content-type: "+ getType() +"\r\n" +
                "\r\n";
    }


    public String getBody() {
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get(getRuote()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(fileContent);
    }

}
