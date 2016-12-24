package Server;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import po.ChooseInfo;
import po.UserInfo;
import po.WordCardInfo;

/**
 * Created by DF on 2016/12/18.
 */
public class Server {
	Socket socket;
    private ObjectInputStream inputFromClient;
    private DataOutputStream outputToClient;
    private ObjectOutputStream ojToClient;
    String queryString = "";
    
    Connection connection;
    
    ResultSet resultSet;

    Statement statement;

    boolean flag = false;

    public static void main(String[] args){
        new Server();
    }

    public Server(){
        try {
            initialzeDB();

            ServerSocket serverSocket = new ServerSocket(123);
            System.out.println("Server started ");

            while (true){
                flag = false;

                socket = serverSocket.accept();

                System.out.println("1234");

                inputFromClient = new ObjectInputStream(socket.getInputStream());

                Object oj = inputFromClient.readObject();
                
                String mark = oj.toString();
                
                int clientflag1 = mark.indexOf("po.UserInfo");
                int clientflag2 = mark.indexOf("po.ChooseInfo");
                int clientflag3 = mark.indexOf("po.WordCardInfo");
                if(clientflag1!=-1){
                    outputToClient = new DataOutputStream(socket.getOutputStream());
                	haddldeLogin(oj);
                }
                else if(clientflag2!=-1){
                	outputToClient = new DataOutputStream(socket.getOutputStream());
                	haddldeLike(oj);
                }
                else if(clientflag3!=-1){
                	haddldeMessage(oj);
                }
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
        
    private void haddldeLogin(Object oj) throws IOException{
    	UserInfo user = (UserInfo) oj;

        //鏍规嵁clientflag鍋氬嚭鐩稿簲鍥炲簲

        switch (user.getClientFlag()){
            case 1:{
                queryString = "select * from Users;";
                try {
                    resultSet = statement.executeQuery(queryString);
                    while (resultSet.next()) {
                        if (resultSet.getString(1).equals(user.getUsername())
                                && resultSet.getString(2).equals(user.getPassword())) {
                            flag = true;
                            queryString = "update Users set isLogin = 1 where username = '"
                            		+ user.getUsername() + "';";
                            statement.execute(queryString);
                            break;
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                outputToClient.writeBoolean(flag);
            }break;
            case 2:{
                queryString = "select * from Users;";
                try {
                    resultSet = statement.executeQuery(queryString);
                    while (resultSet.next()) {
                        if (resultSet.getString(1).equals(user.getUsername())) {
							outputToClient.writeBoolean(false);
                            return;
                        }
                    }
                    queryString = "insert into Users (Username,Passwords) " +
                            "values  ('" + user.getUsername() + "','" + user.getPassword() + "');";
                    try {
                        statement.execute(queryString);
                        flag = true;
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                outputToClient.writeBoolean(flag);
            }break;
            case 3:{
            	String rst = "";
            	queryString = "select * from Users;";
                try {
                    resultSet = statement.executeQuery(queryString);
                    while (resultSet.next()) {
                        if (resultSet.getInt(3) == 1)
                        	rst+="~"+resultSet.getString(1);
                        else
                        	rst+="!"+resultSet.getString(1);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                outputToClient.writeUTF(rst);
            }
        }
    }
    
    private void haddldeLike(Object oj) throws IOException{
    	ChooseInfo likes = (ChooseInfo) oj;
    	if(likes.getClientFlag() == 1){
    	try {
    		queryString = "update numOfLikes set likes = " + (likes.getLikeBaidu() +likes.getAdd_Like_baidu())+ 
    				" where website = 'baidu';";
    		statement.execute(queryString);
    		queryString = "update numOfLikes set likes = " + (likes.getLikeYoudao()+likes.getAdd_Like_youdao()) + 
    				" where website = 'youdao';";
    		statement.execute(queryString);
    		queryString = "update numOfLikes set likes = " + (likes.getLikeBing() +likes.getAdd_Like_bing())+ 
    				" where website = 'bing';";
    		statement.execute(queryString);
    	
			statement.execute(queryString);
            outputToClient.writeBoolean(flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	else if(likes.getClientFlag() == 2){
    		try {
        		queryString = "select likes from numOfLikes where website = 'baidu';";
        		resultSet =  statement.executeQuery(queryString);
        		int result = 0;
        		if(resultSet.next()){
        			result = resultSet.getInt(1);
        		}
                outputToClient.writeInt(result);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	else if(likes.getClientFlag() == 3){
    		try {
        		queryString = "select likes from numOfLikes where website = 'youdao';";
        		resultSet =  statement.executeQuery(queryString);
        		int result = 0;
        		if(resultSet.next()){
        			result = resultSet.getInt(1);
        		}
                outputToClient.writeInt(result);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	else if(likes.getClientFlag() == 4){
    		try {
        		queryString = "select likes from numOfLikes where website = 'bing';";
        		resultSet =  statement.executeQuery(queryString);
        		int result = 0;
        		if(resultSet.next()){
        			result = resultSet.getInt(1);
        		}
                outputToClient.writeInt(result);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    }

    private void haddldeMessage(Object oj) throws IOException{
    	WordCardInfo card = (WordCardInfo) oj;
    	if(card.getChooseFlag() == 1){
    		//ojToClient = new ObjectOutputStream(socket.getOutputStream());
    		outputToClient = new DataOutputStream(socket.getOutputStream());
    	try {
    		queryString = "select * from message where accept = '" +card.getReceiveUser() + "';";
    		resultSet = statement.executeQuery(queryString);
//            ArrayList<BufferedImage> images = new ArrayList();
//    		if(resultSet.next()){
//                BufferedImage image = ImageIO.read(new File(resultSet.getString(3)));
//                images.add(image);
//    		}
//            ojToClient.writeObject(images);
            //outputToClient.w
    		while(resultSet.next()){
    		    BufferedImage image = ImageIO.read(new File(resultSet.getString(3)));
    		    ByteArrayOutputStream out = new ByteArrayOutputStream();
    		    ImageIO.write(image, "jpg", out);
    		    byte[] b = out.toByteArray();
    		    outputToClient.write(b);
//    			byte[] sendBytes = null;
//    			FileInputStream fis = null;
//    	        try {
//    				fis = new FileInputStream(file);
//    			} catch (FileNotFoundException e) {
//    				// TODO 自动生成的 catch 块
//    				e.printStackTrace();
//    			}
//    	        try {
//    				sendBytes = new byte[fis.available()];
//    				fis.read( sendBytes );
//    				fis.close();
//    			} catch (IOException e1) {
//    				// TODO Auto-generated catch block
//    				e1.printStackTrace();
//    			}
//    	        outputToClient.write(sendBytes);
    		}
    		outputToClient.write(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	else if(card.getChooseFlag() == 0){
    		outputToClient = new DataOutputStream(socket.getOutputStream());
    		queryString = "insert into message(send,accept,description) ";
    		queryString = queryString+"values (?,?,?);";
    		System.out.println(queryString);
    		try {
    			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
    			preparedStatement.setString(1,card.getSendUser());
    			preparedStatement.setString(2,card.getReceiveUser());
    			String path = "E:/MessageCards/" + card.getPictureName() + ".jpg";
    			preparedStatement.setString(3,path);
    			File file = new File(path);
    			BufferedImage bi = new BufferedImage(700,500,BufferedImage.TYPE_INT_RGB); 
    	        FileOutputStream outStream = new FileOutputStream(file);   
    	        byte[] temp = card.getPic();
    	        outStream.write(temp);   
    	        outStream.flush();
    	        outStream.close();
    			preparedStatement.execute();
				outputToClient.writeBoolean(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    
    private void initialzeDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded.");

            connection= DriverManager.getConnection("jdbc:mysql://localhost/dictionary","squirrel&panda","123456");
            System.out.println("database connected");

            statement = connection.createStatement();
            
            queryString = "update Users set isLogin = 0;";
            statement.execute(queryString);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
