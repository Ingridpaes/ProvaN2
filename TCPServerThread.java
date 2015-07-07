import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.io.FileWriter;

/**
*
* @author Ingrid
*/

public class TCPServerThread implements Runnable
{

	private Socket _socket;
	private String _msg;
	static TCPServerThread tcp;


public TCPServerThread(Socket socket, String msg)
{
	this._socket= socket;
	this._msg = msg;
}
public void gravarArquivo(String msg){

			try{
				File file = new File("/Temp/msg"+_socket+".txt");
					FileWriter w = new FileWriter(file);
					w.write("Mesagem para o Servidor" +_msg);
					w.close();
				System.out.println("Arquivo"+file+" Foi criado com sucesso: ");
		
				} catch (IOException ex) {
			}
}
	@Override

public void run(){
tcp.gravarArquivo(_msg);
	
}
}