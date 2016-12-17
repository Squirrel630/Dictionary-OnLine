package Client;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import config.LogInFrameConfig;
import po.UserInfo;

/**
 * Created by DF on 2016/12/14.
 */
public class LogIn extends JFrame{

	public static UserInfo userInfo;
	
	public static UserInfo getUser(){
		return userInfo;
	}
	
	JLabel label1,label2;

    JTextField username ;//�����ı������
    JPasswordField password;//������������
    JLabel jLabel1,jLabel2;
    JPanel jp1,jp2,jp3;
    JButton modify,login,signup; //������ť

    String name = "";
    String mima = "";

    String newMima = "";

    Statement statement;

    boolean flag = false;

    ChangePasswordUI  changePasswordUI;

    
	private Client client; //��Ҫ��ÿͻ�������������
	private Socket socket; 
	private ObjectOutputStream objtoServer=null;
	private ObjectInputStream objfromServer=null;
	
    public LogIn(){
    	LogInUI();
    	client=new Client();
    }
    
    public void LogInUI(){
        username = new JTextField(16);
        password = new JPasswordField(16);
        jLabel1 = new JLabel("�û���");
        jLabel2 = new JLabel("��    ��");
        modify = new JButton("�޸�����");
        login = new JButton("��½");
        signup = new JButton("ע��");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        //���ò���
        this.setLayout(new GridLayout(3,1));

        jp1.add(jLabel1);
        jp1.add(username);//��һ���������û������ı���

        jp2.add(jLabel2);
        jp2.add(password);//�ڶ�����������������������

        jp3.add(modify);
        jp3.add(login);
        jp3.add(signup); //������������ȷ�Ϻ�ȡ��

        //        jp3.setLayout(new FlowLayout());  ����//��ΪJPanelĬ�ϲ��ַ�ʽΪFlowLayout�����Կ���ע����δ���.
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);  //�����������ӵ���½������
        //������ʾ
        this.setSize(LogInFrameConfig.WIDTH, LogInFrameConfig.HEIGHT);
        //this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("��½");

        login.addActionListener(new ButtonListener());
        signup.addActionListener(new ButtonListener());
        modify.addActionListener(new ButtonListener());
    }
//
//    private void initialzeDB(){
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver loaded.");
//
//            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/dictionary","squirrel&panda","123456");
//            System.out.println("database connected");
//
//            statement = connection.createStatement();
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String name=username.getText();
        	String psd=password.getPassword().toString();
        	userInfo=new UserInfo(name, psd);
            // = username.getText();
        //      = password.getText();
//            String queryString;
//            java.sql.ResultSet resultSet;
            if (e.getSource() == login) {
//                queryString = "select * from Users";
            	userInfo.setClientFlag(1);;
            	try {
					objtoServer.writeObject(userInfo);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				try {
					objtoServer.flush();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				try {
					int alm=(int)objfromServer.readObject();
					System.out.println(alm);
				} catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
            } else if (e.getSource() == signup) {
            	userInfo.setClientFlag(2);
//                if(name.equals("")){
//                    JOptionPane.showMessageDialog(null, "The user name can not be empty!");
//                    return;
//                }
//                else if(mima.equals("")){
//                    JOptionPane.showMessageDialog(null, "The password can not be empty!");
//                    return;
//                }
//                queryString = "select * from Users";
//                try {
//                    resultSet = statement.executeQuery(queryString);
//                    while (resultSet.next()) {
//                        if (resultSet.getString(1).equals(name)) {
//                            JOptionPane.showMessageDialog(null, "The user already exists!");
//                            return;
//                        }
//                    }
//                    queryString = "insert into Users (Username,Passwords) " +
//                            "values  ('" + name + "','" + mima + "');";
//                    try {
//                        statement.execute(queryString);
//                        JOptionPane.showMessageDialog(null, "You have registered successfully!");
//                    } catch (SQLException e1) {
//                        e1.printStackTrace();
//                    }
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
            }
            else if(e.getSource() == modify){
            	userInfo.setClientFlag(3);
//                if(name.equals("")){
//                    JOptionPane.showMessageDialog(null, "The user name can not be empty!");
//                    return;
//                }
//                else if(mima.equals("")) {
//                    JOptionPane.showMessageDialog(null, "The password can't be empty!");
//                    return;
//                }
//                queryString = "select * from Users where Username = '" + name + "' and Passwords = '"
//                        + mima + "';";
//                try {
//                    resultSet = statement.executeQuery(queryString);
//                    if (!resultSet.next()) {
//                        JOptionPane.showMessageDialog(null, "Modify password failed!");
//                        return;
//                    }
//                    changePasswordUI = new ChangePasswordUI();
//                }catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
            }
            else if(e.getSource() == changePasswordUI.getEnsureChange()){
//                try {
//                    newMima = changePasswordUI.getNewPassWord();
//                    if(newMima.equals("")){
//                        JOptionPane.showMessageDialog(null, "The password can't be empty!");
//                        return;
//                    }
//                    queryString = "update Users set passwords = '" + newMima + "' where username = '" + name + "';";
//                    statement.execute(queryString);
//                    JOptionPane.showMessageDialog(null, "The password was modified successfully!");
//                    return;
//                }catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
            }
        }
    }

    class ChangePasswordUI extends JFrame{
        JPasswordField newPassword;
        JButton ensureChange;
        public ChangePasswordUI() {
            this.setLayout(new FlowLayout());
            this.add(new JLabel("������������"));
            newPassword = new JPasswordField(16);
            this.add(newPassword);
            ensureChange = new JButton("ȷ��");
            this.add(ensureChange);
            this.setSize(400, 80);
            this.setVisible(true);
            this.setTitle("�޸�����");
            this.setLocationRelativeTo(null);
            ensureChange.addActionListener(new ButtonListener());
        }

        public String getNewPassWord(){
            return newPassword.getText();
        }

        public JButton getEnsureChange(){
            return ensureChange;
        }
    }

//    public static void main(String[] args){
//        new LogIn();
//    }
}


