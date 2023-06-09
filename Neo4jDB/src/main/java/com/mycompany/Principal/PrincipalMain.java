/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.Principal;

import com.mycompany.Conexion.ConexionDB;
import com.mycompany.neo4jdb.Neo4jDB;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import java.util.Scanner;

/**
 *
 * @author robyn
 */
public class PrincipalMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionDB c = new ConexionDB();
        Neo4jDB m = new Neo4jDB();    
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        String nombreNodo, puesto, name, relacion, nodorelacion, puestorelacion, etiqueta, newname;
        c.connect();
        do {
            System.out.println("------ Menú CRUD Neo4j ------");
            System.out.println("1. Crear nodos");
            System.out.println("2. Leer nodos");
            System.out.println("3. Actualizar nodo");
            System.out.println("4. Eliminar nodo");
            System.out.println("0. Salir");
            System.out.println("-------------------------------");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea después de leer la opción

            switch (opcion) {
                case 1:
                    System.out.println("Operación: Crear nodos");
                    System.out.println("Ingrese nombre del nodo");
                    nombreNodo=sc.nextLine();
                    System.out.println("Ingrese etiqueta");
                    puesto=sc.nextLine();
                    System.out.println("Ingrese el Nombre del empleado o puesto de trabajo");
                    name = sc.nextLine();
                    System.out.println("Ingresa el tipo de relacion que tendra");
                    relacion = sc.nextLine();
                    System.out.println("Ingrese el area");
                    nodorelacion = sc.nextLine();
                    System.out.println("Ingrese etiqueta del area");
                    etiqueta = sc.nextLine();
                    System.out.println("Ingrese el Nombre del area");
                    puestorelacion = sc.nextLine();
                    m.createNodes(nombreNodo, puesto, name, relacion, nodorelacion, puestorelacion, etiqueta);
                    break;
                case 2:
                    System.out.println("Operación: Leer nodos");
                    m.readNodes();
                    break;
                case 3:
                    System.out.println("Operación: Actualizar nodo");
                    System.out.println("Ingrese nombre del nodo");
                    nombreNodo=sc.nextLine();
                    System.out.println("Ingrese etiqueta");
                    puesto=sc.nextLine();
                    System.out.println("Ingrese el Nombre del empleado o puesto de trabajo");
                    name = sc.nextLine();
                    System.out.println("Ingrese el nuevo nombre");
                    newname = sc.nextLine();
                    m.updateName(nombreNodo, puesto, name, newname);
                    break;
                case 4:
                    System.out.println("Operación: Eliminar nodo");
                     System.out.println("Ingrese nombre del nodo");
                    nombreNodo=sc.nextLine();
                    System.out.println("Ingrese etiqueta4");
                    puesto=sc.nextLine();
                    System.out.println("Ingrese el Nombre del empleado o puesto de trabajo");
                    name = sc.nextLine();
                    m.deleteNode(nombreNodo, puesto, name);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 0);

        c.close();
//        scanner.close();
    }
}

   

    
