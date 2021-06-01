/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDNI;
import java.util.Scanner;
import modelo.DNI;

/**
 *
 * @author Alex Zumba
 */
public class VistaDNI {

    public Scanner entrada;
    private ControladorDNI controladorDNI;

    public VistaDNI(ControladorDNI controladorDNI) {
        entrada = new Scanner(System.in);
        this.controladorDNI = controladorDNI;
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n+++++MENU DNI+++++");
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
                    System.out.println("-----Fin del menu DNI-----");
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese: \n numero: ");
        String numero = entrada.next();
        System.out.print("Codigo Verificacion: ");
        int codigoVerificacion = entrada.nextInt();
        System.out.println("Respuesta:" + controladorDNI.crear(numero, codigoVerificacion));
    }

    public void actualizar() {
        System.out.print("Ingrese: \n numero: ");
        String numero = entrada.next();
        System.out.print("Codigo Verificacion: ");
        int codigoVerificacion = entrada.nextInt();
        System.out.println("Respuesta:" + controladorDNI.actualizar(numero, codigoVerificacion));
    }

    public DNI buscar() {
        System.out.print("Ingrese: \n numero: ");
        String numero = entrada.next();
        System.out.println(controladorDNI.buscar(numero));
        return controladorDNI.buscar(numero);
    }

    public void eliminar() {
        this.buscar();
        System.out.println("Respuesta: " + controladorDNI.eliminar(controladorDNI.getSeleccionado().getNumero()));
    }

    public void listar() {
        for (DNI dni : controladorDNI.getListaDNI()) {
            System.out.println(dni);
        }
    }
}
