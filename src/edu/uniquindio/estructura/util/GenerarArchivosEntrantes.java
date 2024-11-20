package edu.uniquindio.estructura.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerarArchivosEntrantes {

    private final String[] TIPOS_DOCUMENTO = {
            "ABIS", "AFIS", "ANI", "CC", "CC PV", "CC DUP", "CC REN", "CC REC", "CC DIG", "CCT",
            "DCU", "EIS", "HLED-WEB", "MTR", "NIP", "NUIP", "SIC", "SITAC", "TI", "TI PV",
            "TI DUP", "TI REN", "TI REC"
    };

    public void generarArchivosEntrantes() {
        int totalArchivos = 10000;
        int registrosPorArchivo = 100;
        String ruta = "C:\\Users\\johnc\\eclipse-workspace\\ProyectoEstructuraDatos\\recursos\\SolicitudesEntrantes\\";
        Random random = new Random();

        for (int i = 1; i <= totalArchivos; i++) {
            String fileName = ruta + "SolicitudEntrante#" + i + ".csv";

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("tipoDocumento,numeroDocumento,nombreCompleto,fechaNacimiento,departamentoNacimiento,ciudadNacimiento,departamentoResidencia,ciudadResidencia,fondoOrigen,prePensionado,institucionPublica,condecoracion,hijosInpec,familiaPolicia,observacionDisciplinaria,numeroSemanas,declaraRenta\n");

                for (int j = 0; j < registrosPorArchivo; j++) {
                    String registro = generarRegistro(random, j % 10 == 0); // Genera basura en 10% de los casos
                    writer.write(registro + "\n");
                }
            } catch (IOException e) {
                System.err.println("Error al generar el archivo: " + fileName);
                e.printStackTrace();
            }
        }
    }


    private String generarRegistro(Random random, boolean generarBasura) {
        String tipoDocumento = TIPOS_DOCUMENTO[random.nextInt(TIPOS_DOCUMENTO.length)];
        String numeroDocumento = generarNumeroDocumento(random);
        String nombreCompleto = generarNombreCompleto(random);
        String fechaNacimiento = generarFechaNacimiento(random, generarBasura);
        int departamentoNacimiento = generarEntero(random, 1, 100);
        int ciudadNacimiento = generarEntero(random, 1, 100);
        int departamentoResidencia = generarEntero(random, 1, 100);
        int ciudadResidencia = generarEntero(random, 1, 100);
        int fondoOrigen = generarEntero(random, 1, 6);
        int institucionPublica = generarEntero(random, 1, 6);
        int prePensionado = random.nextInt(2);
        int condecoracion = random.nextInt(2);
        int hijosInpec = random.nextInt(2);
        int familiaPolicia = random.nextInt(2);
        int observacionDisciplinaria = random.nextInt(2);
        int numeroSemanas = generarEntero(random, 1, 1000);
        int declaraRenta = random.nextInt(2);

        return String.join(",",
                tipoDocumento,
                numeroDocumento,
                nombreCompleto,
                fechaNacimiento,
                String.valueOf(departamentoNacimiento),
                String.valueOf(ciudadNacimiento),
                String.valueOf(departamentoResidencia),
                String.valueOf(ciudadResidencia),
                String.valueOf(fondoOrigen),
                String.valueOf(prePensionado),
                String.valueOf(institucionPublica),
                String.valueOf(condecoracion),
                String.valueOf(hijosInpec),
                String.valueOf(familiaPolicia),
                String.valueOf(observacionDisciplinaria),
                String.valueOf(numeroSemanas),
                String.valueOf(declaraRenta)
        );
    }

    private String generarNumeroDocumento(Random random) {
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            numero.append(random.nextInt(10));
        }
        return numero.toString();
    }

    private String generarNombreCompleto(Random random) {
        String[] nombres = {"Juan", "María", "Carlos", "Ana", "Luis", "Sofía", "Miguel", "Laura", "Daniela", "David", "Melissa", "Marcela", "Gabriela", "Manuela"};
        String[] apellidos = {"García", "Rodríguez", "Martínez", "Hernández", "López", "González", "Cifuentes", "Murillo", "Perez", "Castaneda", "Cartagena", "Hurtado"};
        return nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)];
    }

    private String generarFechaNacimiento(Random random, boolean generarBasura) {
        int year = generarBasura ? generarEntero(random, 1900, 2024) : generarEntero(random, 1924, 2009);
        int month = generarEntero(random, 1, 12);
        int day = generarEntero(random, 1, 28);
        return String.format("%02d%02d%04d", day, month, year);
    }

    private int generarEntero(Random random, int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
