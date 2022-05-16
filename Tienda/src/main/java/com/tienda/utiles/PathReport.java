/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.utiles;

import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author luis
 */
public class PathReport {

    private JFileChooser choser;

    public String getPath() {
        choser = new JFileChooser();
        choser.addChoosableFileFilter(new FileNameExtensionFilter("reporte", "html"));
        choser.setAcceptAllFileFilterUsed(false);
        int seleccionado = choser.showSaveDialog(null);
        if (seleccionado == APPROVE_OPTION) {
            return (choser.getSelectedFile().getAbsolutePath());
        }
        return "";
    }
}
