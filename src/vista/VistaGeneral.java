/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDNI;
import controlador.ControladorFecha;
import controlador.ControladorPersona;
import controlador.ControladorRegistro;
import java.util.Scanner;
import modelo.DNI;
import modelo.Fecha;
import modelo.Persona;

/**
 *
 * @author Alex Zumba
 */
public class VistaGeneral {

    public Scanner entrada;
    public VistaFecha vistaFecha;
    public ControladorFecha controladorFecha;
    public VistaDNI vistaDNI;
    public ControladorDNI controladorDNI;
    public VistaPersona vistaPersona;
    public ControladorPersona controladorPersona;
    public VistaRegistro vistaRegistro;
    public ControladorRegistro controladorRegistro;

    public VistaGeneral() {
        entrada = new Scanner(System.in);
        controladorFecha = new ControladorFecha();
        controladorDNI = new ControladorDNI();
        controladorPersona = new ControladorPersona();
        controladorRegistro = new ControladorRegistro();
        vistaFecha = new VistaFecha(controladorFecha);
        vistaDNI = new VistaDNI(controladorDNI);
        vistaPersona = new VistaPersona(controladorPersona, controladorFecha, controladorDNI);
        vistaRegistro = new VistaRegistro(controladorRegistro, controladorPersona);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n*****Gestión de Registros*****");
            System.out.println(" 1.- Fecha");
            System.out.println(" 2.- DNI");
            System.out.println(" 3.- Persona");
            System.out.println(" 4.- Registro");
            System.out.println(" 5.- Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    vistaFecha.menu();
                    break;
                case 2:
                    vistaDNI.menu();
                    break;
                case 3:
                    this.persona();
                    break;
                case 4:
                    this.registro();
                    break;
                case 5:
                    System.out.println("\n*****PROGRAMA FINALIZADO*****");
                    break;
            }
        } while (opcion < 5);
    }

    public void persona() {
        Fecha fecha = vistaFecha.buscar();
        DNI dni = vistaDNI.buscar();
        if (fecha != null && dni != null) {
            vistaPersona.menu();
        }
    }

    public void registro() {
        Persona persona = vistaPersona.buscar();
        if (persona != null) {
            vistaRegistro.menu();
        }
    }
}
