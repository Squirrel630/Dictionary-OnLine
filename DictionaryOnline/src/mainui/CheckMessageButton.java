
package mainui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import config.LoginButtonConfig;
import data.Baidu;
import po.WordCardInfo;
import util.DataFactory;

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
			DataFactory.getDataService().checkmessage();
			MessageUI messageUI=new MessageUI();
		}
		
	    class MessageUI extends JFrame {
	    	WordCardInfo wordCardInfo=new WordCardInfo();
	    	
	        public MessageUI() {
	        	wordCardInfo=DataFactory.getDataService().wordCardInfo;
//	        	this.add(new JLabel("send from: "+wordCardInfo.getSendUser()));
//	            this.add(new JLabel("Baidu_Translation:"));
//	            this.add(new JLabel(wordCardInfo.getBaiduTrans()));
//	            this.add(new JLabel("Youdao_Translation:"));
//	            this.add(new JLabel(wordCardInfo.getYoudaoTrans()));
//	            this.add(new JLabel("Bing_Translation:"));
//	            this.add(new JLabel(wordCardInfo.getBingTrans()));
	            this.setSize(400, 600);
	            this.setVisible(true);
	            this.setTitle("·ÖÏí¿¨Æ¬");
	        }
	    }
}
