package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.LogIn;
import config.LoginButtonConfig;

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
			LogIn getlogin=new LogIn();
		}
	
}
