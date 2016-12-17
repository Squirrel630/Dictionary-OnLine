package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.LogIn;
import config.LoginButtonConfig;

public class LoginButton extends JButton implements ActionListener{

	//private static final long serialVersionUID = -6847227296705939178L;

	public LoginButton() {
		setBounds(LoginButtonConfig.LOC_X,LoginButtonConfig.LOC_Y,LoginButtonConfig.WIDTH,LoginButtonConfig.HEIGHT);
		setText("Login");
		setToolTipText("Login & sign up!");
		addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		LogIn getlogin=new LogIn();
	}
	
}

