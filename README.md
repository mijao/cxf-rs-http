# Servicio REST con Apache CXF y Unit Test con JUnit
Implementación de servicio web SOAP con el framework Apache CXF y pruebas unitarias con JUnit

## Instalación, configuración, despliegue y pruebas
Este proyecto contiene un servicio web SOAP llamado OrderProcess. Las siguientes intrucciones permiten probar el mencionado servicio web de forma local.

### Instalación
Clonar el proyecto en un directorio local
```
git clone https://github.com/josearivas/cxf-rs-http.git
```

### Configuración
Descagar las dependencias del proyecto
```
mvn install
```

### Despliegue
Desplegar el WAR contenido en el directorio *target* en el servidor de aplicaciones de su preferencia 

El servicio estará expuesto en el hostname **localhost** y el puerto **8080**

## Prueba del Servicio Web OrderProcess
Acceder al WSDL a través de la siguiente url: http://localhost:8080/OrderProcess?wsdl

### Cliente para Consumir el Servicio Web OrderProcess
Usar SoapUI
