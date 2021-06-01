/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFecha;
import java.util.Scanner;
import modelo.Fecha;

/**
 *
 * @author Alex Zumba
 */
public class VistaFecha {

    public Scanner entrada;
    private ControladorFecha controladorFecha;

    public VistaFecha(ControladorFecha controladorFecha) {
        entrada = new Scanner(System.in);
        this.controladorFecha = controladorFecha;
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n+++++MENU FECHA+++++");
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
                    System.out.println("-----Fin del menu Fecha-----");
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese: \n dia: ");
        int dia = entrada.nextInt();
        System.out.print("mes: ");
        int mes = entrada.nextInt();
        System.out.print("Año: ");
        int anio = entrada.nextInt();
        System.out.println("puesta:" + controladorFecha.crear(dia, mes, anio));
    }

    public void actualizar() {
        System.out.print("Ingrese: \n dia: ");
        int dia = entrada.nextInt();
        System.out.print("mes: ");
        int mes = entrada.nextInt();
        System.out.print("Año: ");
        int anio = entrada.nextInt();
        System.out.println("Respuesta:" + controladorFecha.actualizar(dia, mes, anio));
    }

    public Fecha buscar() {
        System.out.print("Ingrese: \n dia: ");
        int dia = entrada.nextInt();
        System.out.print("mes: ");
        int mes = entrada.nextInt();
        System.out.println(controladorFecha.buscar(dia, mes));
        return controladorFecha.buscar(dia, mes);
    }

    public void eliminar() {
        this.buscar();
        System.out.println("Respuesta: " + controladorFecha.eliminar(controladorFecha.getSeleccionado().getDia(), controladorFecha.getSeleccionado().getMes()));
    }

    public void listar() {
        for (Fecha fecha : controladorFecha.getListaFecha()) {
            System.out.println(fecha);
        }
    }
}
