/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author UrielC
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4000);
            Servidor remoteObject = (Servidor) registry.lookup("RemoteObject");

            String memoryInfo = remoteObject.getMemoryUsage();
            String diskInfo = remoteObject.getDiskSpace();
            String processorInfo = remoteObject.getProcessor();

            System.out.println("Informacion de Memoria: " + memoryInfo);
            System.out.println("Informacion de Disco: " + diskInfo);
            System.out.println("Informacion del Procesador: " + processorInfo);

            Cliente cli = new Cliente(memoryInfo, diskInfo, processorInfo);
            System.out.println("Iniciando cliente");
            cli.startClient();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
