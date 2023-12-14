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
public class Server {
    
    public static void main(String[] args) {
        try {
            WebSocketsServer serv = new WebSocketsServer();
            RemoteObject remoteObject = new RemoteObject();
            Registry registry = LocateRegistry.createRegistry(4000);
            registry.rebind("RemoteObject", remoteObject);

            System.out.println("Servidor Iniciado en el puerto 4000");
            
            System.out.println("Iniciando servidor de webSockets");
            serv.startServer(); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
