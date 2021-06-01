/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDNI;
import controlador.ControladorFecha;
import controlador.ControladorPersona;
import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author Alex Zumba
 */
public class VistaPersona {

    public Scanner entrada;
    private ControladorPersona controladorPersona;
    private ControladorFecha controladorFecha;
    private ControladorDNI controladorDNI;

    public VistaPersona(ControladorPersona controladorPersona, ControladorFecha controladorFecha, ControladorDNI controladorDNI) {
        entrada = new Scanner(System.in);
        this.controladorPersona = controladorPersona;
        this.controladorFecha = controladorFecha;
        this.controladorDNI = controladorDNI;
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n+++++MENU PERSONA+++++");
            System.out.println(" 1.- Crear");
            System.out.println(" 2.- Actualizar");
            System.out.println(" 3.- Buscar");
            System.out.println(" 4.- Eliminar");
            System.out.println(" 5.- Listar");
            System.out.println(" 6.- Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    this.crear();
                    break;
                case 2:
                    this.actualizar();
                    break;
                case 3:
                    this.buscar();
                    break;
                case 4:
                    this.eliminar();
                    break;
                case 5:
                    this.listar();
                    break;
                case 6:
                    System.out.println("-----Fin del menu Persona-----");
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese: \n nombre completo: ");
        entrada.nextLine();
        String nombreCompleto = entrada.nextLine();
        System.out.println("Respuesta:" + controladorPersona.crear(nombreCompleto, controladorFecha.getSeleccionado(), controladorDNI.getSeleccionado()));
    }

    public void actualizar() {
        System.out.print("Ingrese: \n nombre completo: ");
        entrada.nextLine();
        String nombreCompleto = entrada.nextLine();
        System.out.println("Respuesta:" + controladorPersona.actualizar(nombreCompleto, controladorFecha.getSeleccionado(), controladorDNI.getSeleccionado()));
    }

    public Persona buscar() {
        System.out.print("Ingrese: \n nombre completo: ");
        entrada.nextLine();
        String nombreCompleto = entrada.nextLine();
        System.out.println(controladorPersona.buscar(nombreCompleto));
        return controladorPersona.buscar(nombreCompleto);
    }

    public void eliminar() {
        this.buscar();
        System.out.println("Respuesta: " + controladorPersona.eliminar(controladorPersona.getSeleccionado().getNombreCompleto()));
    }

    public void listar() {
        for (Persona persona : controladorPersona.getListaPersona()) {
            System.out.println(persona);
        }
    }
}
