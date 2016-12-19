package Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import po.UserInfo;

/**
 * Created by DF on 2016/12/18.
 */
public class Server {
    private ObjectInputStream inputFromClient;
    private DataOutputStream outputToClient;
    String queryString = "";
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

                Socket socket = serverSocket.accept();

                System.out.println("123");

                inputFromClient = new ObjectInputStream(socket.getInputStream());
                outputToClient = new DataOutputStream(socket.getOutputStream());

                Object oj = inputFromClient.readObject();
                
                String mark = oj.toString();
                
                int clientflag1 = mark.indexOf("po.UserInfo");
                int clientflag2 = mark.indexOf("po.");
                if(clientflag1!=-1){
                	haddldeLogin(oj);
                }
                else if(clientflag2!=-1){
                	haddldeLike(oj);
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

        //根据clientflag做出相应回应

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
    	UserInfo user = (UserInfo) oj;
    }
    
    private void initialzeDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded.");

            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/dictionary","squirrel&panda","123456");
            System.out.println("database connected");

            statement = connection.createStatement();
            
            queryString = "update Users set isLogin = 0;";
            statement.execute(queryString);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
