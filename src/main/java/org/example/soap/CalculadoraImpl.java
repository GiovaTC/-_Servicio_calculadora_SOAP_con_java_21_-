package org.example.soap;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.example.soap.Calculadora")
public class CalculadoraImpl implements Calculadora {

    @Override
    public double sumar(double numero1, double numero2) {
        return numero1 + numero2;
    }

    @Override
    public double restar(double numero1, double numero2) {
        return numero1 - numero2;
    }

    @Override
    public double multiplicar(double numero1, double numero2) {
        return numero1 * numero2;
    }

    @Override
    public double dividir(double numero1, double numero2) {

        if (numero2 == 0) {
            throw new IllegalArgumentException(
                    "no se puede dividir por cero"
            );
        }
        return numero1 / numero2;
    }
}
