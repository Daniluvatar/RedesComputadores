package ec.edu.epn.redes.date.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * Trivial TCP client.
 */
public class DateClient {

	private static int SERVER_PORT = 9090;
	
	/**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the server, then connects to it and displays the message that
     * it serves.
     */
	
	public static void main(String[] args) throws IOException {
        
		String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is\n" +
            							   "running the date service on port "+SERVER_PORT+":");
        
		//Establece la conexión con el servidor mediante un socket
		Socket clientSocket = new Socket(serverAddress, SERVER_PORT);

		//Obtiene el mensaje enviado por el servidor a través del socket
		InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());

		//Lee los datos del mensaje
		BufferedReader input = new BufferedReader(inputStream);
		String answer = input.readLine();

		//Imprime los datos del mensaje
		JOptionPane.showMessageDialog(null, answer);
		System.exit(0);
    }
	
}
