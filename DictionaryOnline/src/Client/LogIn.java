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
import javax.swing.JOptionPane;
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

    JTextField username ;//定义文本框组件
    JPasswordField password;//定义密码框组件
    JLabel jLabel1,jLabel2;
    JPanel jp1,jp2,jp3;
    JButton modify,login,signup; //创建按钮

    String name = "";
    String mima = "";

    String newMima = "";

    Statement statement;

    boolean flag = false;

    ChangePasswordUI  changePasswordUI;

    
	private Client client; //需要获得客户端主界面引用
	
    public LogIn(){
    	LogInUI();
    }
    
    public void LogInUI(){
        username = new JTextField(16);
        password = new JPasswordField(16);
        jLabel1 = new JLabel("用户名");
        jLabel2 = new JLabel("密    码");
        modify = new JButton("修改密码");
        login = new JButton("登陆");
        signup = new JButton("注册");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        //设置布局
        this.setLayout(new GridLayout(3,1));

        jp1.add(jLabel1);
        jp1.add(username);//第一块面板添加用户名和文本框

        jp2.add(jLabel2);
        jp2.add(password);//第二块面板添加密码和密码输入框

        jp3.add(modify);
        jp3.add(login);
        jp3.add(signup); //第三块面板添加确认和取消

        //        jp3.setLayout(new FlowLayout());  　　//因为JPanel默认布局方式为FlowLayout，所以可以注销这段代码.
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);  //将三块面板添加到登陆框上面
        //设置显示
        this.setSize(LogInFrameConfig.WIDTH, LogInFrameConfig.HEIGHT);
        //this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("登陆");

        login.addActionListener(new ButtonListener());
        signup.addActionListener(new ButtonListener());
        modify.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String name=username.getText();
        	String psd=password.getText();
        	userInfo=new UserInfo(name, psd);
        	client=new Client();
            if (e.getSource() == login) {
              try {
            	userInfo.setClientFlag(1);
                client.getOutputToServer().writeObject(userInfo);
                boolean a = client.getInputFromServer().readBoolean();

                System.out.println(a);
              }catch (IOException ex){
                System.err.println(ex);
              }
            } else if (e.getSource() == signup) {
            	userInfo.setClientFlag(2);
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "The user name can not be empty!");
                    return;
                }
                else if(psd.equals("")){
                    JOptionPane.showMessageDialog(null, "The password can not be empty!");
                    return;
                }
                try {
                	userInfo.setClientFlag(2);
                    client.getOutputToServer().writeObject(userInfo);
                    boolean a = client.getInputFromServer().readBoolean();

                    System.out.println(a);
                 }catch (IOException ex){
                    System.err.println(ex);
                 }
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
            this.add(new JLabel("请输入新密码"));
            newPassword = new JPasswordField(16);
            this.add(newPassword);
            ensureChange = new JButton("确定");
            this.add(ensureChange);
            this.setSize(400, 80);
            this.setVisible(true);
            this.setTitle("修改密码");
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

