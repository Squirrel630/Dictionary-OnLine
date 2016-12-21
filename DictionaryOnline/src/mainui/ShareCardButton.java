package mainui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import config.LoginButtonConfig;
import util.DataFactory;

public class ShareCardButton extends JButton implements ActionListener{
	public ShareCardButton() {
		setBounds(LoginButtonConfig.LOC_X3,LoginButtonConfig.LOC_Y3,LoginButtonConfig.WIDTH,LoginButtonConfig.HEIGHT);
		setText("Share~");
		setToolTipText("Share the word card to your friends!");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ShareCardUI shareCardUI=new ShareCardUI();
//		DataFactory.getDataService().shareCard();
	}

    class ShareCardUI extends JFrame implements ActionListener{
        public JButton ensureChange=new JButton("确定");
        public JTextField  username = new JTextField(16);
        public ShareCardUI() {
            this.setLayout(new FlowLayout());
            this.add(new JLabel("请输入要发送的用户名字"));
            ensureChange = new JButton("发送");
        
            this.add(username);
            this.add(new JLabel(" "));
            this.add(ensureChange);
            this.setSize(400, 200);
            this.setVisible(true);
            this.setTitle("分享卡片");
            this.setLocationRelativeTo(null);
            ensureChange.addActionListener(this);
        }

        public String getReciveUser(){
            return username.getText();
        }

        public JButton getEnsureChange(){
            return ensureChange;
        }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			//DataFactory.getDataService().wordCardInfo.setSendUser(getSendUser());
			if(e.getSource() == ensureChange){
				DataFactory.getDataService().wordCardInfo.setReceiveUser(getReciveUser());
				DataFactory.getDataService().shareCard();
			}
		}
    }
}

