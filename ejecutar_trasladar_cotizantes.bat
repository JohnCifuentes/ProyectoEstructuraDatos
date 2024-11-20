@echo off
rem Cambiar al directorio donde está la carpeta src de tu proyecto
cd /d C:\Users\johnc\eclipse-workspace\ProyectoEstructuraDatos\src

rem Compilar las clases de tu proyecto y generar los archivos .class en la carpeta bin
javac -d ../bin edu\Main.java

rem Cambiar al directorio bin donde están los archivos .class
cd /d C:\Users\johnc\eclipse-workspace\ProyectoEstructuraDatos\bin

rem Ejecutar el método trasladarSolicitudCotizantesAprobados de la clase Main y guardar la salida en un archivo
java edu.Main trasladarSolicitudCotizantesAprobados > salida.txt 2>&1

rem Pausar para ver si hubo algún error en la consola
pause
