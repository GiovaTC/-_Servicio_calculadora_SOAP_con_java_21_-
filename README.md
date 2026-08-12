# -_Servicio_calculadora_SOAP_con_java_21_- :.
Servicio Calculadora SOAP con Java 21:

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/9943c776-4f2b-430c-b4f2-0855c75a2f8e" />  

```
Proyecto completo y sencillo de SOAP Web Service con Java 21 + IntelliJ IDEA + Maven, pensado específicamente para levantarlo localmente y probarlo con SoapUI.

1. Estructura del proyecto
ServicioCalculadoraSOAP/
│
├── pom.xml
│
└── src/
    └── main/
        └── java/
            └── com/
                └── ejemplo/
                    └── soap/
                        ├── Calculadora.java
                        ├── CalculadoraImpl.java
                        └── PublicarServicio.java

2. pom.xml
Usaremos Jakarta XML Web Services (JAX-WS) y una implementación Metro para poder ejecutar el servicio con Java 21.

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ejemplo</groupId>
    <artifactId>ServicioCalculadoraSOAP</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>

        <!-- API Jakarta XML Web Services -->
        <dependency>
            <groupId>jakarta.xml.ws</groupId>
            <artifactId>jakarta.xml.ws-api</artifactId>
            <version>4.0.2</version>
        </dependency>

        <!-- Implementación SOAP -->
        <dependency>
            <groupId>com.sun.xml.ws</groupId>
            <artifactId>jaxws-rt</artifactId>
            <version>4.0.3</version>
        </dependency>

    </dependencies>

    <build>
        <plugins>

            <!-- Compilador Java 21 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>

                <configuration>
                    <source>21</source>
                    <target>21</target>
                </configuration>
            </plugin>

            <!-- Ejecutar aplicación -->
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.5.0</version>

                <configuration>
                    <mainClass>
                        com.ejemplo.soap.PublicarServicio
                    </mainClass>
                </configuration>

            </plugin>

        </plugins>
    </build>

</project>

3. Calculadora.java
Esta será la interfaz del servicio SOAP.

package com.ejemplo.soap;

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

Tenemos cuatro operaciones:
sumar
restar
multiplicar
dividir

4. CalculadoraImpl.java
Esta clase contiene la implementación de las operaciones.

package com.ejemplo.soap;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.ejemplo.soap.Calculadora")
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
                    "No se puede dividir por cero"
            );
        }

        return numero1 / numero2;
    }
}

5. PublicarServicio.java
Esta clase publica el servicio SOAP.

package com.ejemplo.soap;

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

6. Proyecto completo
La estructura final queda así:
ServicioCalculadoraSOAP/
│
├── pom.xml
│
└── src/
    └── main/
        └── java/
            └── com/
                └── ejemplo/
                    └── soap/
                        ├── Calculadora.java
                        ├── CalculadoraImpl.java
                        └── PublicarServicio.java

7. Crear el proyecto en IntelliJ IDEA
Abre IntelliJ IDEA.
Selecciona:
New Project

Selecciona:
Maven
Configura:
Name:
ServicioCalculadoraSOAP
Language:

Java
JDK:
21
Build system:
Maven

Puedes utilizar:
GroupId:
com.ejemplo

ArtifactId:
ServicioCalculadoraSOAP

Después pulsa:
Create

8. Crear los paquetes
Dentro de:
src/main/java
crea:

com.ejemplo.soap

Dentro del paquete crea las siguientes clases:

Calculadora.java
CalculadoraImpl.java
PublicarServicio.java

Copia el código anterior en cada archivo.

9. Descargar las dependencias Maven
Después de guardar el pom.xml, IntelliJ debería detectar automáticamente Maven.

En la parte superior derecha puede aparecer:
Load Maven Changes
Pulsa sobre él.

También puedes abrir:
View
→ Tool Windows
→ Maven

y pulsar:

Reload All Maven Projects
Maven descargará las dependencias necesarias.

10. Ejecutar el servicio
Abre:
PublicarServicio.java

y pulsa el botón verde:

▶ Run

Deberías obtener algo parecido a:
------------------------------------------
 SERVICIO SOAP INICIADO
------------------------------------------
URL:
http://localhost:8080/calculadora

WSDL:
http://localhost:8080/calculadora?wsdl
------------------------------------------
Presiona CTRL + C para detener el servicio.

Importante: No cierres esta ejecución, porque el servicio debe permanecer funcionando mientras lo pruebas desde SoapUI.

11. Comprobar el WSDL
Abre tu navegador y entra a:
http://localhost:8080/calculadora?wsdl
Deberías obtener un documento XML.
El WSDL describe el servicio SOAP y sus operaciones.

Entre las operaciones encontrarás:
sumar
restar
multiplicar
dividir

12. Instalar SoapUI
Puedes utilizar SoapUI Open Source para realizar las pruebas.
Busca la versión de SoapUI para tu sistema operativo en su sitio oficial e instálala normalmente.

13. Crear un proyecto SOAP en SoapUI
Abre SoapUI.

Selecciona:
File
→ New SOAP Project

Aparecerá una ventana.
En:
Project Name

escribe:
PruebaCalculadoraSOAP

En:
Initial WSDL

introduce:
http://localhost:8080/calculadora?wsdl

Después pulsa:
OK

SoapUI leerá automáticamente nuestro WSDL.

14. Operaciones disponibles
En el panel izquierdo deberías observar algo parecido a:

PruebaCalculadoraSOAP
│
└── CalculadoraImplService
    │
    └── CalculadoraImplPort
        │
        ├── dividir
        ├── multiplicar
        ├── restar
        └── sumar

15. Probar sumar
Haz doble clic sobre:
sumar
SoapUI generará automáticamente una solicitud.

Puede aparecer algo similar a:
<soapenv:Envelope
    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:soap="http://soap.ejemplo.com/">

    <soapenv:Header/>

    <soapenv:Body>

        <soap:sumar>
            <arg0>10</arg0>
            <arg1>20</arg1>
        </soap:sumar>

    </soapenv:Body>

</soapenv:Envelope>

Dependiendo de la versión de las herramientas, los nombres de los parámetros pueden aparecer como arg0 y arg1.
Coloca:

arg0 = 10
arg1 = 20

Pulsa el botón:

▶
para ejecutar la petición.

16. Resultado esperado
SoapUI debería mostrar una respuesta similar a:
<S:Envelope
    xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">

    <S:Body>

        <ns2:sumarResponse
            xmlns:ns2="http://soap.ejemplo.com/">

            <return>30.0</return>

        </ns2:sumarResponse>

    </S:Body>

</S:Envelope>

El resultado es:
30.0

17. Probar restar
En SoapUI abre:
restar

Utiliza:
<arg0>50</arg0>
<arg1>15</arg1>

Resultado:
35.0

18. Probar multiplicar
Utiliza:
<arg0>8</arg0>
<arg1>5</arg1>

Resultado:
40.0

19. Probar dividir
Utiliza:
<arg0>100</arg0>
<arg1>4</arg1>

Resultado:
25.0

20. Probar división por cero
También podemos comprobar el manejo de errores.
Envía:
<arg0>100</arg0>
<arg1>0</arg1>

El método Java detectará:
if (numero2 == 0)
y generará una excepción.

Esto es útil para aprender cómo SOAP maneja errores y posteriormente podemos implementar un SOAP Fault personalizado.

21. Flujo completo del proyecto
El funcionamiento es:

                     ┌──────────────────┐
                     │      SoapUI      │
                     │                  │
                     │  numero1 = 10    │
                     │  numero2 = 20    │
                     └────────┬─────────┘
                              │
                              │ SOAP/XML
                              ▼
                   ┌───────────────────────┐
                   │    Servicio SOAP      │
                   │                       │
                   │    localhost:8080     │
                   │    /calculadora       │
                   └───────────┬───────────┘
                               │
                               ▼
                   ┌───────────────────────┐
                   │   CalculadoraImpl     │
                   │                       │
                   │   sumar(10,20)        │
                   └───────────┬───────────┘
                               │
                               ▼
                             30.0
                               │
                               ▼
                       ┌────────────────┐
                       │     SoapUI     │
                       │                │
                       │      30.0      │
                       └────────────────┘

22. Resumen de las URLs
Una vez iniciado el programa:
Recurso
URL
Servicio SOAP
http://localhost:8080/calculadora

WSDL
http://localhost:8080/calculadora?wsdl

La URL más importante para SoapUI es:
http://localhost:8080/calculadora?wsdl

Conclusión
Con este proyecto tienes una base funcional para estudiar:
SOAP
WSDL
XML
JAX-WS
Servicios web
Operaciones web
Pruebas con SoapUI
Java 21
Maven
IntelliJ IDEA

El proyecto utiliza una calculadora sencilla para que puedas concentrarte en comprender el funcionamiento de un Web Service SOAP y su comunicación mediante XML .
:. . / .
