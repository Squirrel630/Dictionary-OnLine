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
    private  static ObjectInputStream ojFromServer;
	
	
	public Client() {
		// TODO 自动生成的构造函数存根
		connectToServer();
	}
	
	//连接到服务器
	public void connectToServer(){
		try{
			socket=new Socket("localhost",123);	
			inputFromServer=new DataInputStream(socket.getInputStream());	
			outputToServer=new ObjectOutputStream(socket.getOutputStream());
			
		}
		catch(IOException ex){
			System.err.println(ex);
		}
	}
	
//	public Client(int i) {
//		// TODO 自动生成的构造函数存根
//		connectToServer(i);
//	}
//	
//	public void connectToServer(int i){
//		try{
//			socket=new Socket("localhost",123);		
//			outputToServer=new ObjectOutputStream(socket.getOutputStream());
//			ojFromServer=new ObjectInputStream(socket.getInputStream());
//			
//		}
//		catch(IOException ex){
//			System.err.println(ex);
//		}
//	}
	

	public DataInputStream getInputFromServer(){
		return inputFromServer;
	}
	
//	public ObjectInputStream getOjFromServer(){
//		return ojFromServer;
//	}
	
	public ObjectOutputStream getOutputToServer(){
		return outputToServer;
	}
	public Socket getSocket(){
		return socket;
	}
}
