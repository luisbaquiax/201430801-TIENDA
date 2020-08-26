/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.entidad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author luis
 */
public class Reporte {

    public Reporte() {

    }

    /**
     * Método para escribir los reportes y exportarlos en archivo.html
     *
     * @param ruta
     * @param contenido
     */
    public void reporteHTML(String ruta, String contenido) {
        try {
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter escribeArchivo = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(escribeArchivo);
            bw.write(contenido);
            bw.close();
        } catch (IOException e) {
        }
    }
}
