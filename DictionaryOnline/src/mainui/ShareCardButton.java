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
        public JButton ensureChange=new JButton("ȷ��");
        public JTextField  username = new JTextField(16);
        public ShareCardUI() {
            this.setLayout(new FlowLayout());
            this.add(new JLabel("������Ҫ���͵��û�����"));
            ensureChange = new JButton("����");
        
            this.add(username);
            this.add(new JLabel(" "));
            this.add(ensureChange);
            this.setSize(400, 200);
            this.setVisible(true);
            this.setTitle("����Ƭ");
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
			// TODO �Զ����ɵķ������
			//DataFactory.getDataService().wordCardInfo.setSendUser(getSendUser());
			if(e.getSource() == ensureChange){
				DataFactory.getDataService().wordCardInfo.setReceiveUser(getReciveUser());
				DataFactory.getDataService().shareCard();
			}
		}
    }
}

