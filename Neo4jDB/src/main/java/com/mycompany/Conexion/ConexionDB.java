/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Conexion;
import org.neo4j.driver.*;

/**
 *
 * @author robyn
 */
public class ConexionDB {

    private static final String uri = "bolt://localhost:7687";
    private static final String user = "neo4j";
    private static final String password = "empresa1616";
    private static Driver driver;

    public static void connect() {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public static void close() {
        driver.close();
    }

    public static Session getSession() {
        return driver.session();
    }
}

