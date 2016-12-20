package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.LogIn;
import config.LoginButtonConfig;
import util.DataFactory;
import util.UIFactory;

public class ShareCardButton extends JButton implements ActionListener{
	public ShareCardButton() {
		setBounds(LoginButtonConfig.LOC_X3,LoginButtonConfig.LOC_Y3,LoginButtonConfig.WIDTH,LoginButtonConfig.HEIGHT);
		setText("Share~");
		setToolTipText("Share the word card to your friends!");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DataFactory.getDataService().shareCard();
	}
}
