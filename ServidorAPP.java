import java.net.*;
import java.net.Socket;
import java.io.*;

/**
*
* @author ingrid
*/

public class ServidorApp {
static int _porta= 9090;
static String msg_cli;
static ServerSocket servidorApp;
static Socket skt = new Socket();

public static void criarThread() throws InterruptedException
{

	Thread tcpserverthread = new Thread(new TCPServerThread(skt , msg_cli ));

		tcpserverthread.start();
		
		tcpserverthread.join();
}

private static void aguardarConexao() throws IOException
{

	ServidorApp.servidorApp = new ServerSocket(_porta);
	System.out.println("A porta foi aberta "+ _porta + "Aguardando uma nova Conexao...");

InetAddress inet = InetAddress.getByName("localhost");


		while(true){
				
			ServidorApp.skt = servidorApp.accept();
			System.out.println("Informações do Cliente..");
			System.out.println(inet.getHostAddress());
			System.out.println(inet.getHostName());
			BufferedReader recebercliente = new BufferedReader(new InputStreamReader(skt.getInputStream()));

				ServidorApp.msg_cli = recebercliente.readLine();
				System.out.println("Mensagem recebida do cliente: " + msg_cli);

}
			}

public static void main (String [] args) throws IOException, InterruptedException 

{

ServidorApp.aguardarConexao();
ServidorApp.criarThread();

}
}