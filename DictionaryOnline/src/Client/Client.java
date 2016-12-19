package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.*;

public class Client{
	Socket socket=null;
	private static DataInputStream inputFromServer;
    private  static ObjectOutputStream outputToServer;
	
	
	public Client() {
		// TODO �Զ����ɵĹ��캯�����
		connectToServer();
	}
	
	//���ӵ�������
	public void connectToServer(){
		try{
			socket=new Socket("TTBOP1FGBU5YBDC",123);	
			inputFromServer=new DataInputStream(socket.getInputStream());	
			outputToServer=new ObjectOutputStream(socket.getOutputStream());
			
		}
		catch(IOException ex){
			System.err.println(ex);
		}
	}
	

	public DataInputStream getInputFromServer(){
		return inputFromServer;
	}
	
	public ObjectOutputStream getOutputToServer(){
		return outputToServer;
	}
	public Socket getSocket(){
		return socket;
	}
}
