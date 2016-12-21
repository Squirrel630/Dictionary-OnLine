package mainui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Client.Client;
import config.LoginButtonConfig;
import po.UserInfo;

public class OnlineUserButton extends JButton implements ActionListener{

		//private static final long serialVersionUID = -6847227296705939178L;

		public OnlineUserButton() {
			setBounds(LoginButtonConfig.LOC_X2,LoginButtonConfig.LOC_Y2,LoginButtonConfig.WIDTH,LoginButtonConfig.HEIGHT);
			setText("Users");
			setToolTipText("Show the online users!");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
		//	LogIn getlogin=new LogIn();
			try {
				Client client = new Client();
//        		userInfo.setClientFlag(3);
				UserInfo temp = new UserInfo("", "");
				temp.setClientFlag(3);
        		client.getOutputToServer().writeObject(temp);
				String userlist = client.getInputFromServer().readUTF();
				System.out.println(userlist);
				new ShowUserList(userlist);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	class ShowUserList extends JFrame{
    	public JTextArea jta1,jta2;
    	public ShowUserList(String str){
    		jta1 = new JTextArea();
    		jta2 = new JTextArea();
    		JPanel p1 = new JPanel();
    		p1.setLayout(new BorderLayout());
    		p1.add(new JLabel("在线"),BorderLayout.NORTH);
    		p1.add(jta1,BorderLayout.CENTER);
    		JPanel p2 = new JPanel();
    		p2.setLayout(new BorderLayout());
    		p2.add(new JLabel("离线"),BorderLayout.NORTH);
    		p2.add(jta2,BorderLayout.CENTER);

    		//while(!str.equals("")){
            	String[] tokens1;
            	tokens1 = str.split("~",0);
            	for(int i = 0;i<tokens1.length;i++){
            		if(!tokens1[i].equals("") && tokens1[i].charAt(0)!='!'){
            			String temp = tokens1[i];
            			String[] tokens2 = temp.split("!",0);
            			int j = 0;
            			while(tokens2[j].equals("")){
            				j++;
            			}
            			jta1.append(tokens2[j]+"\n");
            			for(j = j+1;j<tokens2.length;j++){
            				if(!tokens2[j].equals(""))
            					jta2.append(tokens2[j]+"\n");
            			}
            		}
            		else if(!tokens1[i].equals("") && tokens1[i].charAt(0)=='!'){
            			String temp = tokens1[i];
            			String[] tokens2 = temp.split("!",0);
            			int j = 0;
            			for(;j<tokens2.length;j++){
            				if(!tokens2[j].equals(""))
            					jta2.append(tokens2[j]+"\n");
            			}
            		}
            	}
            //}
    		
    		setLayout(new GridLayout(1,2));
    		add(p1);
    		add(p2);
    		setTitle("用户列表");
    		setSize(500,300);
    		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            
    	}
    }
}
