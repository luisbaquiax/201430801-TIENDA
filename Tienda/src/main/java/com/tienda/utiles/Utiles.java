/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.utiles;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author luis
 */
public class Utiles {

    public static final int TAM_25 = 25;

    public Utiles() {
    }

    /**
     * Pone una imagen/icono a un JLabel
     *
     * @param label
     * @param ruta
     */
    public void ponerIconoLabel(JLabel label, String ruta) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        label.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(
                label.getSize().width, label.getSize().height, Image.SCALE_SMOOTH)));
    }

    /**
     *
     * @param label
     * @param ruta
     * @param tam
     */
    public void ponerIconoLabel(JLabel label, String ruta, int tam) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        label.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(
                tam, tam, Image.SCALE_SMOOTH)));
    }

    /**
     * Ponde una imagen/icono a un JButoon
     *
     * @param button
     * @param ruta
     */
    public void ponerIconoButton(JButton button, String ruta) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        button.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(
                button.getSize().width, button.getSize().height, Image.SCALE_SMOOTH)));
    }

    /**
     *
     * @param button
     * @param ruta
     * @param tam
     */
    public void ponerIconoButton(JButton button, String ruta, int tam) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        button.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(
                tam, tam, Image.SCALE_SMOOTH)));
    }

    public static ImageIcon getIcon(String ruta, int tam) {
        ImageIcon icono1 = new ImageIcon(ruta);
        return new ImageIcon(icono1.getImage().getScaledInstance(
                tam, tam, Image.SCALE_SMOOTH));

    }

    public static void reinicarCampos(JTextField... txts) {
        for (JTextField txt : txts) {
            txt.setText("");
        }
    }

    public static boolean esDecimal(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
