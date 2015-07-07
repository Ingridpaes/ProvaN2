import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
*
* @author Ingrid

*/
public class TCPCliente {

public static void main(String argv[]) throws Exception 
{

	String sentence; 
	String modifiedSentence; 
	BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in)); 
	System.out.println("Estabelecendo Conexão local... ");
	Socket clientSocket = new Socket("localhost", 9090); 
	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
	System.out.print("Digite sua mensagem:");
	sentence = inFromUser.readLine(); 
	outToServer.writeBytes(sentence + '\n'); 
	modifiedSentence = inFromServer.readLine(); 
	System.out.println("Resposta do servidor: " + modifiedSentence); 
	clientSocket.close();
}
}