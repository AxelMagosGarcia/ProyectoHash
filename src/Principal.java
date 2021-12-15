/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axelm
 */

import javax.swing.JTextArea;

public class Principal {
    public static void main(String[] args) {
        try {
            int i, n, resp;
            int m = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el tamaño de la tabla"));
            Hash[] h = new Hash[m];
            for (i = 0; i < m; i++) {
                h[i] = new Hash();
                h[i].estado = 0;
            }
            do {
                resp = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Menú Principal \n\n"
                        + "Insertar (1)\nBuscar (2)\nEliminar (3)\nSalir (4)"));
                switch (resp) {
                    case 1:
                        n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese la matricula a ser insertada en la tabla:"));
                        String nom= javax.swing.JOptionPane.showInputDialog("Ingrese el Nombre a registrar");
                        String prome= javax.swing.JOptionPane.showInputDialog("Ingrese el Promedio a registrar");
                        String datos=nom+"\t"+prome;
                        Hash.insertaHash(h, m, n,datos);
                        break;
                    case 2:
                        n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número a ser buscado en la tabla:"));
                        String v = Hash.buscaHash(h, m, n);
                        if (v == "-1") {
                            javax.swing.JOptionPane.showMessageDialog(null, "Número no encontrado");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(null,new JTextArea( "MATRICULA\tNOMBRE\tPROMEDIO\n"+n+"\t"+v));
                            
                        }
                        break;
                    case 3:
                        n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número a ser eliminado de la tabla:"));
                        i = Hash.eliminaHash(h, m, n);
                        if (i == -1) {
                            javax.swing.JOptionPane.showMessageDialog(null, "Número no encontrado");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(null, "Número eliminado con éxito");
                        }
                        break;
                    case 4:
                        System.exit(0);
                    default:
                }
            } while (resp != 4);
        } catch (NumberFormatException nfe) {
            javax.swing.JOptionPane.showMessageDialog(null, "Está Saliendo del Programa");
        } catch (OutOfMemoryError ome) {
            javax.swing.JOptionPane.showMessageDialog(null, "No Hay Espacio");
        }
    }
}