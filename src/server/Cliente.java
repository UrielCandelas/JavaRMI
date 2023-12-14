/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author UrielC
 */
public class Cliente extends Conexion {

    private final String memoryInfo;
    private final String diskInfo;
    private final String processorInfo;

    public Cliente(String memoryInfo, String diskInfo, String processorInfo) throws IOException {
        super("cliente");
        this.memoryInfo = memoryInfo;
        this.diskInfo = diskInfo;
        this.processorInfo = processorInfo;
    }

    public void startClient() //Método para iniciar el cliente
    {
        try {
            //Flujo de datos hacia el servidor
                salidaServidor = new DataOutputStream(cs.getOutputStream());

                //Se enviarán dos mensajes
                String text = memoryInfo + " " + diskInfo + " " + processorInfo;

                salidaServidor.writeUTF(text);
                

                cs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
