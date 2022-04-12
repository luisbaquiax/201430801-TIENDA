/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.utiles;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author luis
 */
public class Utiles {

    /**
     * Pone una imagen/icono a un JLabel
     *
     * @param label
     * @param ruta
     */
    public static void ponerIconoLabel(JLabel label, String ruta) {
        ImageIcon icono1 = new ImageIcon(ruta);
        label.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(
                label.getSize().width, label.getSize().height, Image.SCALE_SMOOTH)));
    }

    /**
     *
     * @param label
     * @param ruta
     * @param tam
     */
    public static void ponerIconoLabel(JLabel label, String ruta, int tam) {
        ImageIcon icono1 = new ImageIcon(ruta);
        label.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(
                tam, tam, Image.SCALE_SMOOTH)));
    }

    /**
     * Ponde una imagen/icono a un JButoon
     *
     * @param button
     * @param ruta
     */
    public static void ponerIconoButton(JButton button, String ruta) {
        ImageIcon icono1 = new ImageIcon(ruta);
        button.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(
                button.getSize().width, button.getSize().height, Image.SCALE_SMOOTH)));
    }
}
