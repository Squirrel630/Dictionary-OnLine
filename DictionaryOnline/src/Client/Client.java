package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client{
	Socket socket=null;
	private ObjectOutputStream objtoServer=null;
	private ObjectInputStream objfromServer=null;
	
	
	public Client() {
		// TODO �Զ����ɵĹ��캯�����
		connectToServer();
	}
	
	//���ӵ�������
	public void connectToServer(){
		try{
			socket=new Socket("localhost",8000);	
			objfromServer=new ObjectInputStream(socket.getInputStream());	
			objtoServer=new ObjectOutputStream(socket.getOutputStream());
			
		}
		catch(IOException ex){
			System.err.println(ex);
		}
	}
	

	
}
