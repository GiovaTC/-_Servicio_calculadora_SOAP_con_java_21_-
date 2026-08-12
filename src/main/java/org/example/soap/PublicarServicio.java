package org.example.soap;

import jakarta.xml.ws.Endpoint;

public class PublicarServicio {

    public static void main(String[] args) {

        String direccion = "http://localhost:8080/calculadora";

        Endpoint.publish(
                direccion,
                new CalculadoraImpl()
        );

        System.out.println("------------------------------------------");
        System.out.println(" SERVICIO SOAP INICIADO");
        System.out.println("------------------------------------------");
        System.out.println("URL:");
        System.out.println(direccion);
        System.out.println();
        System.out.println("WSDL:");
        System.out.println(direccion + "?wsdl");
        System.out.println("------------------------------------------");
        System.out.println("Presiona CTRL + C para detener el servicio.");
    }
}
