/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectog8;

import javax.swing.JOptionPane;

/**
 *
 * @author NIKY
 */
public class Menu {
    private int opc;
    private Lista c=new Lista();
    Dato d = new Dato();

    public void mostrarMenu() {
        opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                "***MENÚ PRINCIPAL***\n\n"
                + "1. Registrar usuario\n"
                + "2. Iniciar Sesion\n"
                + "3. Inactivar usuario\n"
                + "4. Salir del sistema\n\n"
                + "Digite su opción:"));
        switch (opc) {
            case 1: {
                c.agregar();
                mostrarMenu();
                break;
            }
            case 2: {
                c.mostrarLista();
                mostrarMenu();
                break;
            }
            case 3: {
                c.inactivarusuario();
                mostrarMenu();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,
                        "Opción incorrecta, revise!");
            }
        }
    }
    
}
