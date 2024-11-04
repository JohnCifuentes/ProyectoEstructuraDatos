package edu.uniquindio.estructura.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AdministrarArchivosDirectorio {
	
	public AdministrarArchivosDirectorio() {
		
	}

    // Método para capturar los nombres de los archivos y directorios en el directorio asignado
    public List<String> obtenerNombresObjetosEnDirectorio(String rutaDirectorio) {
        List<String> nombres = new ArrayList<>();
        File directorio = new File(rutaDirectorio);
        
        if (directorio.exists() && directorio.isDirectory()) {
            for (File archivo : directorio.listFiles()) {
                nombres.add(archivo.getName());
            }
        }
        
        return nombres;
    }

    // Método para crear un nuevo directorio
    public boolean crearDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            return directorio.mkdirs();
        }
        return false; // Ya existe
    }

    // Método para mover un archivo de un directorio X a un directorio Y
    public boolean moverArchivo(String rutaArchivoOrigen, String rutaDirectorioDestino) {
        Path origenPath = Paths.get(rutaArchivoOrigen);
        Path destinoPath = Paths.get(rutaDirectorioDestino).resolve(origenPath.getFileName());
        
        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para comprimir un directorio
    public boolean comprimirDirectorio(String rutaDirectorio, String rutaArchivoZip) {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists() || !directorio.isDirectory()) {
            return false; // El directorio no existe o no es un directorio
        }
        
        try (FileOutputStream fos = new FileOutputStream(rutaArchivoZip);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {
            
            comprimirDirectorioRecursivo(directorio, directorio.getName(), zipOut);
            return true;
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método auxiliar para comprimir directorios de forma recursiva
    private void comprimirDirectorioRecursivo(File archivo, String nombreArchivo, ZipOutputStream zipOut) throws IOException {
        if (archivo.isDirectory()) {
            if (nombreArchivo.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(nombreArchivo));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(nombreArchivo + "/"));
                zipOut.closeEntry();
            }
            for (File hijo : archivo.listFiles()) {
                comprimirDirectorioRecursivo(hijo, nombreArchivo + "/" + hijo.getName(), zipOut);
            }
        } else {
            try (FileInputStream fis = new FileInputStream(archivo)) {
                ZipEntry zipEntry = new ZipEntry(nombreArchivo);
                zipOut.putNextEntry(zipEntry);
                
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
            }
        }
    }
}
