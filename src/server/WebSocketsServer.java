package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WebSocketsServer extends Conexion {

    private List<DataOutputStream> clientesSalida;

    public WebSocketsServer() throws IOException {
        super("servidor");
        clientesSalida = new ArrayList<>();
    }

    public void startServer() {
        try {
            System.out.println("Esperando..."); // Esperando conexión

            while (true) {
                cs = ss.accept(); // Accept comienza el socket y espera una conexión desde un cliente

                System.out.println("Cliente en linea");

                // Se obtiene el flujo de salida del cliente para enviarle mensajes
                salidaCliente = new DataOutputStream(cs.getOutputStream());

                // Se le envía un mensaje al cliente usando su flujo de salida
                salidaCliente.writeUTF("Petición recibida y aceptada");
                clientesSalida.add(salidaCliente);

                // Se obtiene el flujo entrante desde el cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

                while ((mensajeServidor = entrada.readLine()) != null) // Mientras haya mensajes desde el cliente
                {
                    // Se muestra por pantalla el mensaje recibido
                    System.out.println(mensajeServidor);
                    for (DataOutputStream clienteSalida : clientesSalida) {
                        clienteSalida.writeUTF(mensajeServidor);
                    }
                }

                System.out.println("Fin de la conexión");
                cs.close(); // Se finaliza la conexión con el cliente
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
