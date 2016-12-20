
package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import config.LoginButtonConfig;
import util.DataFactory;

public class CheckMessageButton  extends JButton implements ActionListener{

		//private static final long serialVersionUID = -6847227296705939178L;

		public CheckMessageButton() {
			setBounds(LoginButtonConfig.LOC_X4-20,LoginButtonConfig.LOC_Y4,LoginButtonConfig.WIDTH+20,LoginButtonConfig.HEIGHT);
			setText("Message");
			setToolTipText("Show the online users!");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			DataFactory.getDataService().checkmessage();
		}
	
}
