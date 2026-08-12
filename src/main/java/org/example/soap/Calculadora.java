package org.example.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface Calculadora {

    @WebMethod
    double sumar(double numero1, double numero2);

    @WebMethod
    double restar(double numero1, double numero2);

    @WebMethod
    double multiplicar(double numero1, double numero2);

    @WebMethod
    double dividir(double numero1, double numero2);
}
