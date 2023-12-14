/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package server;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author UrielC
 */
public interface Servidor extends Remote {
    public String getMemoryUsage() throws RemoteException;
    public String getDiskSpace() throws RemoteException;
    public String getProcessor() throws RemoteException;
}
