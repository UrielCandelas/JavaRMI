/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;

/**
 *
 * @author UrielC
 */
public class RemoteObject extends UnicastRemoteObject implements Servidor{
    private MemoryMXBean memoryMXBean;
    private MemoryUsage memoryUsage;
    private OperatingSystemMXBean osMXBean;
    
    public RemoteObject() throws RemoteException {
        super();
        this.memoryMXBean = ManagementFactory.getMemoryMXBean();
        this.memoryUsage = this.memoryMXBean.getHeapMemoryUsage();
        this.osMXBean = ManagementFactory.getOperatingSystemMXBean();
    }
    
    @Override
    public String getMemoryUsage() throws RemoteException {
        return "Monticulo maximo de memoria: " + memoryUsage.getMax() + ", Monticulo usado de memoria: " + memoryUsage.getUsed();
    }

    @Override
    public String getDiskSpace() throws RemoteException {
        File file = new File("/");
        long totalSpace = file.getTotalSpace();
        long freeSpace = file.getFreeSpace();
        return "Espacio total del disco: " + totalSpace + ", Espacio Libre: " + freeSpace;
    }
    
    @Override
    public String getProcessor() throws RemoteException {
        return "Procesadores disponibles: " + osMXBean.getAvailableProcessors();
    }
}
