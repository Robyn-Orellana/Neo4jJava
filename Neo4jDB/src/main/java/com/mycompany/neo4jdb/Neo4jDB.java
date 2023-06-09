/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.neo4jdb;

import com.mycompany.Conexion.ConexionDB;
import org.neo4j.driver.*;

/**
 *
 * @author robyn
 */
public class Neo4jDB{

    ConexionDB c = new ConexionDB();

    public void createNodes(String nombreNodo, String puesto, String name, String relacion, String nodorelacion, String puestorelacion, String etiqueta) {
        try (Session session = c.getSession()) {
            session.run("CREATE ("+nombreNodo+":"+puesto+" {name: '"+name+"'})");
            session.run("MATCH ("+nombreNodo+":"+puesto+"), ("+nodorelacion+":"+etiqueta+") "+
                    "WHERE "+nombreNodo+".name = '"+name+"' AND "+nodorelacion+".name = '"+puestorelacion+"'"
                            + " CREATE ("+nombreNodo+")-[:"+relacion+"]->("+nodorelacion+")");
        }
    }

    public void readNodes() {
            try (Session session = c.getSession()) {
            Result result = session.run("MATCH (n) RETURN n");
            while (result.hasNext()) {
                var record = result.next();
                System.out.println(record.get("n").asNode().asMap());
            }
        }
        
    }

    public void updateName(String nombreNodo, String puesto, String name, String newname) {
        try (Session session = c.getSession()) {
            session.run("MATCH ("+nombreNodo+":"+puesto+" {name: '"+name+"'}) SET "+nombreNodo+".name = '"+newname+"'");
            System.out.println("Nombre actualizado");
        }
    }

    public void deleteNode(String nombreNodo, String puesto, String name) {
        try (Session session = c.getSession()) {
            session.run("MATCH ("+nombreNodo+":"+puesto+" {name: '"+name+"'}) DETACH DELETE "+nombreNodo);
            System.out.println("Puesto eliminado");
        }
    }
}

    


    



