/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorPersona;
import controlador.ControladorRegistro;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import modelo.Registro;

/**
 *
 * @author Alex Zumba
 */
public class VistaRegistro {

    public Scanner entrada;
    private ControladorRegistro controladorRegistro;
    private ControladorPersona controladorPersona;
    public DateFormat formatoFecha;

    public VistaRegistro(ControladorRegistro controladorRegistro, ControladorPersona controladorPersona) {
        entrada = new Scanner(System.in);
        this.controladorRegistro = controladorRegistro;
        this.controladorPersona = controladorPersona;
        formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n+++++MENU REGISTRO+++++");
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
                    System.out.println("-----Fin del menu Registro-----");
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese: \n codigo: ");
        String codigo = entrada.next();
        System.out.print("Fecha (dd/mm/yyyy): ");
        String fecha = entrada.next();
        try {
            System.out.println("Respuesta:" + controladorRegistro.crear(codigo, formatoFecha.parse(fecha), controladorPersona.getSeleccionado()));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void actualizar() {
        System.out.print("Ingrese: \n codigo: ");
        String codigo = entrada.next();
        System.out.print("Fecha (dd/mm/yyyy): ");
        String fecha = entrada.next();
        try {
            System.out.println("Respuesta:" + controladorRegistro.actualizar(codigo, formatoFecha.parse(fecha), controladorPersona.getSeleccionado()));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void buscar() {
        System.out.print("Ingrese: \n codigo: ");
        String codigo = entrada.next();
        System.out.println(controladorRegistro.buscar(codigo));
    }

    public void eliminar() {
        this.buscar();
        System.out.println("Respuesta: " + controladorRegistro.eliminar(controladorRegistro.getSeleccionado().getCodigo()));
    }

    public void listar() {
        for (Registro registro : controladorRegistro.getListaRegistro()) {
            System.out.println(registro);
        }
    }
}
