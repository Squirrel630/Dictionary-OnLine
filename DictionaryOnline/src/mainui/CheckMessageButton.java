
package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.LoginButtonConfig;
import po.WordCardInfo;

public class CheckMessageButton  extends JButton implements ActionListener{

		//private static final long serialVersionUID = -6847227296705939178L;

		public CheckMessageButton() {
			setBounds(LoginButtonConfig.LOC_X4-20,LoginButtonConfig.LOC_Y4,LoginButtonConfig.WIDTH+20,LoginButtonConfig.HEIGHT);
			setText("Message");
			setToolTipText("check your message!");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MessageUI messageUI=new MessageUI();
//			DataFactory.getDataService().checkmessage();
		}
		
	    class MessageUI extends JFrame {
	    	WordCardInfo wordCardInfo=new WordCardInfo();
	    	private JPanel card;
	    	private JLabel img;
	    	public JButton left=new JButton("<");
	    	public JButton right=new JButton(">");
	    	public JLabel cardTitle=new JLabel("【我收到的单词卡】");
	    	
	        public MessageUI() {
	        	setLayout(null);
	            this.setSize(750, 700);
	            this.setVisible(true);
	            this.setTitle("单词卡");
	        	this.add(cardTitle);
	        	cardTitle.setBounds(300, 0, 200, 80);
	            this.add(left);
	            left.setBounds(320, 600, 50, 50);
	            this.add(right);
	            right.setBounds(420, 600, 50, 50);
	            img=new JLabel(new ImageIcon("image.jpg"));
	            
	    		img.setBounds(25, 60, 700, 500);
	    		add(img);
	            
	    		this.setLocationRelativeTo(null);
//	    		  login.addActionListener(new ButtonListener());
	            left.addActionListener(new ButtonListener());
	            right.addActionListener(new ButtonListener());
	        }
	        
	        private class ButtonListener implements ActionListener {
	        	public void actionPerformed(ActionEvent e) {
	        	   if(e.getSource()==left){
	        		   updateImg(-1);
	        	   }
	        	   else if(e.getSource()==right){
	        		   updateImg(1);
	        	   }
	           }
	        }
	        
	        private void updateImg(int i){
	        	img.setIcon(new ImageIcon("Icon_Baidu.png"));
	        }
	    }
}
