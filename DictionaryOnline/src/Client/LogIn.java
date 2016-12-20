package Client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import config.LogInFrameConfig;
import po.UserInfo;
import util.DataFactory;

/**
 * Created by DF on 2016/12/14.
 */
public class LogIn extends JFrame{

//	public static UserInfo userInfo;
//	
//	public static UserInfo getUser(){
//		return userInfo;
//	}
	
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
	
    public LogIn(){
    	LogInUI();
    }
    
    public void LogInUI(){
        username = new JTextField(16);
        password = new JPasswordField(16);
        jLabel1 = new JLabel("�û���");
        jLabel2 = new JLabel("��    ��");
        modify = new JButton("�鿴�û��б�");
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
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("��½");

        login.addActionListener(new ButtonListener());
        signup.addActionListener(new ButtonListener());
        modify.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String name=username.getText();
        	String psd=password.getText();
        	DataFactory.getDataService().myuserInfo=new UserInfo(name, psd);
        	client=new Client();
            if (e.getSource() == login) {
              try {
            	DataFactory.getDataService().myuserInfo.setClientFlag(1);
                client.getOutputToServer().writeObject(DataFactory.getDataService().myuserInfo);
                boolean a = client.getInputFromServer().readBoolean();
                flag = a;
                if(flag == true){
                	JOptionPane.showMessageDialog(null, "��½�ɹ�!");
                }
                System.out.println(a);
              }catch (IOException ex){
                System.err.println(ex);
              }
            } else if (e.getSource() == signup) {
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "The user name can not be empty!");
                    return;
                }
                else if(psd.equals("")){
                    JOptionPane.showMessageDialog(null, "The password can not be empty!");
                    return;
                }
                try {
                	DataFactory.getDataService().myuserInfo.setClientFlag(2);
                    client.getOutputToServer().writeObject(DataFactory.getDataService().myuserInfo);
                    boolean a = client.getInputFromServer().readBoolean();
                    if(a == true)
                    	JOptionPane.showMessageDialog(null, "ע��ɹ���");
                    System.out.println(a);
                 }catch (IOException ex){
                    System.err.println(ex);
                 }
            }
            else if(e.getSource() == modify && flag == true){
            	try {
            		DataFactory.getDataService().myuserInfo.setClientFlag(3);
            		client.getOutputToServer().writeObject(DataFactory.getDataService().myuserInfo);
					String userlist = client.getInputFromServer().readUTF();
					System.out.println(userlist);
					new ShowUserList(userlist);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            else if(e.getSource() == changePasswordUI.getEnsureChange()){
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
            this.setTitle("�û��б�");
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
    
    class ShowUserList extends JFrame{
    	public JTextArea jta1,jta2;
    	public ShowUserList(String str){
    		jta1 = new JTextArea();
    		jta2 = new JTextArea();
    		JPanel p1 = new JPanel();
    		p1.setLayout(new BorderLayout());
    		p1.add(new JLabel("����"),BorderLayout.NORTH);
    		p1.add(jta1,BorderLayout.CENTER);
    		JPanel p2 = new JPanel();
    		p2.setLayout(new BorderLayout());
    		p2.add(new JLabel("����"),BorderLayout.NORTH);
    		p2.add(jta2,BorderLayout.CENTER);

    		//while(!str.equals("")){
            	String[] tokens1;
            	tokens1 = str.split("~",0);
            	for(int i = 0;i<tokens1.length;i++){
            		if(!tokens1[i].equals("")){
            			String temp = tokens1[i];
            			String[] tokens2 = temp.split("!",0);
            			int j = 0;
            			while(true){
            				if(!tokens2[j].equals("")){
            					jta1.append(tokens2[j]+"\n");
            					break;
            				}
            			}
            			for(j = j+1;j<tokens2.length;j++){
            				if(!tokens2[j].equals(""))
            					jta2.append(tokens2[j]+"\n");
            			}
            		}
            	}
            //}
    		
    		setLayout(new GridLayout(1,2));
    		add(p1);
    		add(p2);
    		setTitle("�û��б�");
    		setSize(500,300);
    		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            
    	}
    }
}